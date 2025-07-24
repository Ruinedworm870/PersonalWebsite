import { NextRequest } from "next/server";
import { GoogleGenAI } from "@google/genai";

export const runtime = 'edge';

const ai = new GoogleGenAI({
    apiKey: process.env.GEMINI_API_KEY
});

export async function POST(req: NextRequest)
{
    const {input} = (await req.json()) as {input: string};
    
    if (!input || input.length > 256 || input.length == 0)
    {
        return new Response(
            'Invalid Input',
            {status: 400}
        )
    }
    
    const prompt = `
        You're an expert Software Engineer. Give me a list of 5 to 10 unique projects I can complete with these technologies: ${input}
    `
    
    try
    {
        const response = await ai.models.generateContentStream({
            model: "gemini-2.0-flash-lite",
            contents: prompt,
            config: {
                thinkingConfig: {
                    thinkingBudget: 0
                }
            }
        });

        const encoder = new TextEncoder();

        const stream = new ReadableStream({
            async start(controller) {
                for await (const chunk of response) {
                    const textPart = chunk.text;

                    if (textPart) {
                        controller.enqueue(encoder.encode(textPart));
                    }
                }
                controller.close();
            }
        });

        return new Response(stream, {
            headers: {
                'Content-Type': "text/plain",
                "Cache-Control": "no-cache"
            }
        });
    }
    catch (error: any)
    {
        const message = error?.message || '';
        const status = error?.statusCode || error?.code;

        if (status === 429 || message.includes("rate") || message.includes("limit"))
        {
            return new Response("Rate limit exceeded. Please try again in a few minutes.",
                {
                    status: 429
                }
            );
        }

        return new Response("An error occured while generating content.",
            {
                status: 500
            }
        );
    }
}
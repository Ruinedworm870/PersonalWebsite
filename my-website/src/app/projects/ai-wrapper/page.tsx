
import "@/styles/loadingSpinner.css";

import GlitchText from "@/components/text/GlitchText";
import ChatClient from "./ChatClient";
import { Paragraph, TextBlock } from "@/components/text/TextBlock";

export default async function AiChatPage()
{    
    return (
        <div
            style={{
                padding: "25px 15px"
            }}
        >
            <GlitchText color="title" size={64} bold align="center">AI-Powered Project Idea Generator</GlitchText>
            
            <TextBlock
                style={{
                    marginTop:25
                }}
            >
                <Paragraph>
                    I built this AI Wrapper to demonstrate my ability with API's and to learn how AI Wrappers work. This wrapper is really simple, it takes in information about your tech stack and returns a list of 5 to 10 ideas for projects to complete with your tech stack. I'm using the Google Gemini API for this wrapper because they have a free tier, and it's currently using the Gemini 3.1 Flash-Lite Preview model because it has a high free rate limit.  
                </Paragraph>
            </TextBlock>
            
            <ChatClient />
        </div>
        
    )
}
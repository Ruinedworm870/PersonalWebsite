'use client'

import MainButtonClient from "@/components/buttons/MainButtonClient";
import MainText from "@/components/text/MainText";
import { Colors } from "@/hooks/Colors";
import { useEffect, useRef, useState } from "react";
import ReactMarkdown from 'react-markdown'

interface Props{

}

const ChatClient: React.FC<Props> = () =>
{
    const [input, setInput] = useState("");
    const [response, setResponse] = useState("");
    const [loading, setLoading] = useState(false);

    const bottomRef = useRef<HTMLDivElement>(null);

    useEffect(() => {
        if (bottomRef.current)
        {
            bottomRef.current.scrollIntoView({ behavior: "smooth" });
        }
    }, [response]);
    
    const HandleSubmit = async () =>
    {
        if (loading)
        {
            return;
        }

        setResponse("");
        setLoading(true);
        
        try
        {
            const res = await fetch("/api/generate", {
                method: "POST",
                body: JSON.stringify({ input: input }),
                headers: { "Content-Type": "application/json" }
            });

            if (!res.ok)
            {
                const errorText = await res.text();
                setResponse(errorText);
                setLoading(false);
                return;
            }
            
            if (!res.body)
            {
                setResponse("Empty response from server.");
                setLoading(false);
                return;
            }

            const reader = res.body.getReader();
            const decoder = new TextDecoder();

            while (true) {
                const { done, value } = await reader.read();

                if (done) break;

                setResponse(prev => prev + decoder.decode(value, { stream: true }));
            }
        }
        catch (error: any)
        {
            setResponse("Network error. Please try again later.");
        }
        finally
        {
            setLoading(false);
        }
    }

    return (
        <div>
            <div
                style={{
                    display: "flex",
                    flexDirection: "column",
                    justifyContent: "center",
                    alignItems: "center",
                    marginTop: 40
                }}
            >
                <MainText style={{width: "60%"}} size={20} bold>Describe your tech stack:</MainText>
                <textarea
                    value={input}
                    onChange={e => setInput(e.target.value)}
                    maxLength={256}
                    rows={4}
                    style={{
                        width: "60%",
                        fontSize: 18,
                        color: Colors.text,
                        borderColor: Colors.primary,
                        backgroundColor: "transparent",
                        borderRadius: 5,
                        outline: 0,
                        padding: 5,
                        marginTop: 10
                    }}
                />
                
                <MainButtonClient
                    onClick={HandleSubmit}
                    style={{
                        marginTop: 20
                    }}
                >
                    <MainText size={20} bold>Generate</MainText>
                </MainButtonClient>
            </div>
            
            <div
                style={{
                    width: "80%",
                    margin: "25px auto",
                    color: Colors.text,
                    textWrap: "wrap",
                    lineHeight: 1.5
                }}
            >
                <ReactMarkdown>
                    {response}
                </ReactMarkdown>
                <div ref={bottomRef}></div>
            </div>
            
            {loading &&
                <div className="spinner"></div>
            }
        </div>
    )
}

export default ChatClient;
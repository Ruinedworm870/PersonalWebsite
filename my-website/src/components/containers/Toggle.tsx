'use client'

import { CSSProperties, ReactNode, useRef, useState } from "react";
import MainText from "../text/MainText";

interface Props{
    children?: ReactNode | ReactNode[];
    title?: string;
    fontSize?: number;
    style?: CSSProperties;
    gap?: CSSProperties['gap'];
    contentId?: string;
    parentId?: string;
}

const Toggle: React.FC<Props> = ({ children, title, fontSize = 16, style, gap = 5, contentId, parentId }) =>
{
    const contentRef = useRef<HTMLDivElement>(null);

    const [maxHeight, setMaxHeight] = useState(0);   
    
    const OpenToggle = () =>
    {
        if (!contentRef.current) return;
        
        setMaxHeight(contentRef.current.scrollHeight);

        if (parentId)
        {
            const parent = document.getElementById(parentId);
            
            if (parent)
            {
                parent.style.maxHeight = contentRef.current.scrollHeight + parent.style.maxHeight;
            }
        }
    }
    
    const CloseToggle = () =>
    {
        setMaxHeight(0);
    }
    
    const Toggle = () =>
    {
        if (maxHeight > 0)
        {
            CloseToggle();
        }
        else
        {
            OpenToggle();
        }
    }
    
    return (
        <div
            style={{
                display: "inline-block",
                ...style
            }}
        >
            <div
                onClick={Toggle}
                style={{
                    userSelect: "none",
                    cursor: "pointer",
                    width: "fit-content"
                }}
            >
                <MainText
                    color={maxHeight > 0 ? "title" : "hover"}
                    size={fontSize}
                    bold
                    style={{
                        display: "flex",
                        gap: gap
                    }}
                >
                    <div
                        style={{
                            width: 15
                        }}
                    >
                        {maxHeight > 0 ? "-" : "+"}
                    </div>
                    {title}
                </MainText>
            </div>
            <div
                ref={contentRef}
                id={contentId}
                style={{
                    display: "block",
                    overflow: "hidden",
                    transition: "0.2s ease",
                    maxHeight: maxHeight
                }}
            >
                {children}
            </div>
        </div>
    )
}

export default Toggle;
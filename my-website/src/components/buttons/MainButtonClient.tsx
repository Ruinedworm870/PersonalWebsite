'use client'

import { Colors } from "@/hooks/Colors";
import { CSSProperties, ReactNode } from "react";

interface Props{
    children?: ReactNode | ReactNode[];
    style?: CSSProperties;
    padding?: CSSProperties['padding'];
    onClick?: () => void;
}

const MainButtonClient: React.FC<Props> = ({children, style, padding = 5, onClick}) =>
{
    return (
        <button    
            onClick={onClick}
            className="box"
            style={{
                borderColor: Colors.primary,
                borderRadius: 10,
                borderWidth: 1,
                borderStyle: "solid",
                padding: padding,
                cursor: "pointer",
                userSelect: "none",
                ...style
            }}
        >
            {children}
        </button>

    )
}

export default MainButtonClient;
import { CSSProperties, ReactNode } from "react";

export interface MainTextProps{
    children?: ReactNode | ReactNode[];
    color?: "normal" | "title" | "hover";
    size?: number;
    align?: CSSProperties['textAlign'];
    style?: CSSProperties;
    bold?: boolean;
    className?: string;
}

const MainText: React.FC<MainTextProps> = ({ children, color = "normal", size = 16, align = "left", style, bold, className }) =>
{
    const s: CSSProperties = {
        fontSize: size,
        textAlign: align,
        fontWeight: bold ? "bold" : "normal"
    }
    
    return (
        <div
            className={ color + "Text" + " " + className }
            style={{ ...style, ...s }}
        >
            {children}
        </div>
    )
}

export default MainText;
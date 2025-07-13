import { CSSProperties, ReactNode } from "react";

interface Props{
    children?: ReactNode | ReactNode[];
    color?: "normal" | "title" | "hover";
    size?: number;
    align?: CSSProperties['textAlign'];
    style?: CSSProperties;
    bold?: boolean;
}

const MainText: React.FC<Props> = ({ children, color = "normal", size = 16, align = "left", style, bold }) =>
{
    const s: CSSProperties = {
        fontSize: size,
        textAlign: align,
        fontWeight: bold ? "bold" : "normal"
    }
    
    return (
        <div
            className={ color + "Text" }
            style={{ ...style, ...s }}
        >
            {children}
        </div>
    )
}

export default MainText;
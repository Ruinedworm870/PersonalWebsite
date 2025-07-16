import { Colors } from "@/hooks/Colors";
import { CSSProperties, ReactElement } from "react";

interface Props{
    children?: ReactElement<ParagraphProps> | ReactElement<ParagraphProps>[];
    width?: CSSProperties['width'];
    fontSize?: CSSProperties['fontSize'];
    lineHeight?: CSSProperties['lineHeight'];
    style?: CSSProperties;
}

//Pass paragraphs as children
export const TextBlock: React.FC<Props> = ({children, width = "90%", fontSize = 18, lineHeight = 1.5, style}) =>
{
    return (
        <div
            style={{
                width: width,
                fontSize: fontSize,
                lineHeight: lineHeight,
                margin: "auto",
                ...style
            }}
        >
            { children }
        </div>
    )
}

interface ParagraphProps{
    children?: string;
    textIndent?: CSSProperties['textIndent'];
    color?: string;
    style?: CSSProperties;
}

//Paragraphs go inside a text block to split up paragraphs
export const Paragraph: React.FC<ParagraphProps> = ({ children, textIndent = 16, color = Colors.text, style }) =>
{
    return (
        <>
            <br></br>
            <div
                style={{
                    textIndent: textIndent,
                    color: color,
                    ...style
                }}
            >
                {children}
            </div>
        </>
    )
}
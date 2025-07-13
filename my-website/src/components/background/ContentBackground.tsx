import { Colors } from "@/hooks/Colors";
import { ReactNode } from "react";

interface Props{
    children?: ReactNode | ReactNode[];
}

const ContentBackground: React.FC<Props> = ({ children }) =>
{
    return (
        <div
            style={{
                width: "85%",
                backgroundColor: Colors.background,
                margin: "auto",
                top: 0,
                left: 0,
                right: 0,
                bottom: 0,
                position: "absolute",
                borderWidth: 1,
                borderColor: Colors.primary,
                borderStyle: "solid"
            }}
        >
            { children }
        </div>
    )
}

export default ContentBackground;
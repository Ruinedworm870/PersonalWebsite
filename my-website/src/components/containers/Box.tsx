import { Colors } from "@/hooks/Colors";
import { CSSProperties, ReactNode } from "react";

interface Props{
    children?: ReactNode | ReactNode[];
    padding?: CSSProperties['padding'];
    width?: CSSProperties['width'];
}

const Box: React.FC<Props> = ({ children, padding = 5, width = 100 }) =>
{
    return (
        <div
            className="box"
            style={{
                borderColor: Colors.primary,
                borderRadius: 10,
                borderWidth: 1,
                borderStyle: "solid",
                flex: 1,
                padding: padding,
                width: width
            }}
        >
            { children }
        </div>
    )
}

export default Box;
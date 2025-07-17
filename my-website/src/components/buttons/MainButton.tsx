import Link from "next/link";
import Box from "../containers/Box";
import { CSSProperties, HTMLAttributeAnchorTarget, ReactNode } from "react";
import { Url } from "next/dist/shared/lib/router/router";

interface Props{
    children?: ReactNode | ReactNode[];
    linkStyleManual?: boolean;
    linkStyle?: CSSProperties;
    additionalStyle?: CSSProperties; //Additional style only applys when linkStyleManual is false
    boxPadding?: CSSProperties['padding'];
    target?: HTMLAttributeAnchorTarget;
    href: Url;
}

const MainButton: React.FC<Props> = ({ children, linkStyleManual = false, linkStyle, additionalStyle, boxPadding = "5px 10px", target = "_blank", href }) =>
{
    return (
        <Link
            href={href}
            target={target}
            style={linkStyleManual ? linkStyle : {
                textDecoration: "none",
                width: "fit-content",
                margin: "25px auto",
                display: "block",
                ...additionalStyle
            }}
        >
            <Box
                padding={boxPadding}
                width={"fit-content"}
            >
                { children }
            </Box>
        </Link>
    )
}

export default MainButton;
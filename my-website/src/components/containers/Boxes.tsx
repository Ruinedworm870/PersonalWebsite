import { CSSProperties } from "react";
import Box from "./Box";
import Image from "next/image";
import MainText from "../text/MainText";
import Link from "next/link";

export type BoxesType = {
    image: string;
    title: string;
    text: string;
    link: string;
}[];

interface Props{
    data?: BoxesType;
    style?: CSSProperties;
    imageSize?: number;
    boxWidth?: CSSProperties['width'];
    gap?: CSSProperties['gap'];
    boxPadding?: CSSProperties['padding'];
}

const Boxes: React.FC<Props> = ({ data = [], style, imageSize = 256, boxWidth = 100, gap = 10, boxPadding = 5 }) =>
{
    const GetBoxContent = (image: string, title: string, text: string) =>
    {
        return (
            <>
                <div
                    style={{
                        width: "100%",
                        display: "flex",
                        justifyContent: "center"
                    }}
                >
                    <Image
                        src={image}
                        alt={title}
                        width={imageSize}
                        height={imageSize}
                    />
                </div>
                <MainText bold align="center" style={{margin: "8px 0"}}>{title}</MainText>
                <MainText align="center">{text}</MainText>
            </>
        )
    }
    
    return (
        <div
            style={{
                display: "flex",
                margin: "auto",
                width: "90%",
                justifyContent: "center",
                alignItems: "stretch",
                flexWrap: "wrap",
                gap: gap,
                ...style
            }}
        >
            {data.map((d, index) => (
                <div
                    key={index}
                    style={{
                        display: "flex"
                    }}
                >
                    {d.link != "" &&
                        <Link
                            href={d.link}
                            style={{
                                textDecoration: "none",
                                cursor: "pointer",
                                display: "flex",
                                flex: 1
                            }}
                        >
                            <Box
                                width={boxWidth}
                                padding={boxPadding}
                            >
                                {GetBoxContent(d.image, d.title, d.text)}
                            </Box>
                        </Link>
                    }
                    
                    {d.link == "" &&
                        <Box
                            width={boxWidth}
                            padding={boxPadding}
                        >
                            {GetBoxContent(d.image, d.title, d.text)}
                        </Box>
                    }
                </div>
            ))}
        </div>
    )
}

export default Boxes;
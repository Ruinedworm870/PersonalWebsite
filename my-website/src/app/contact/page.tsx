import GlitchText from "@/components/text/GlitchText";
import MainText from "@/components/text/MainText";
import Link from "next/link";

export default function Contact()
{
    return (
        <div
            style={{
                padding: "25px 15px"
            }}
        >
            <GlitchText color="title" size={64} bold align="center">Contact Me</GlitchText>
            
            <MainText align="center" size={24} style={{ margin: 16 }}>I prefer to be contacted by email. You can email me at:</MainText>
            
            <Link
                href={"mailto:williamsmolinskijr@gmail.com"}
                style={{
                    textDecoration: "none",
                    width: "fit-content",
                    margin: "auto"
                }}
            >
                <MainText color="hover" size={24} align="center" bold>williamsmolinskijr@gmail.com</MainText>
            </Link>
        </div>
    )
}
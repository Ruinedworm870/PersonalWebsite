import Boxes, { BoxesType } from "@/components/containers/Boxes";
import GlitchText from "@/components/text/GlitchText";
import Link from "next/link";

export default function Home()
{
    const featuredContentBoxes: BoxesType = [
        {
            image: "/images/SpacePrivateerIcon.png",
            title: "Space Privateer",
            text: "My first game jam game, made with Unity",
            link: "/projects/space-privateer"
        },
        {
            image: "/images/API.png",
            title: "About Me Website",
            text: "Website running with next.js",
            link: "/projects/about-me-website"
        },
        {
            image: "/images/TechEmpireTycoon.png",
            title: "Tech Empire Tycoon",
            text: "My third mobile game currently in development, made with React Native and Expo",
            link: "/projects/tech-empire-tycoon"
        }
    ]
    
    return (
        <div
            style={{
                padding: "25px 15px"
            }}
        >
            <GlitchText color="title" size={64} bold align="center">William Smolinski Jr</GlitchText>
            
            <div
                style={{
                    display: "flex",
                    gap: 5,
                    justifyContent: "center",
                    alignItems: "center",
                    marginTop: 10
                }}
            >
                <Link
                    href={"mailto:williamsmolinskijr@gmail.com"}
                    style={{ textDecoration: "none" }}
                >
                    <GlitchText size={20} bold align="center" color="hover">williamsmolinskijr@gmail.com</GlitchText>
                </Link>
                
                <GlitchText size={20} bold align="center">|</GlitchText>

                <Link
                    href={"https://github.com/Ruinedworm870"}
                    style={{ textDecoration: "none" }}
                    target="_blank"
                >
                    <GlitchText size={20} bold align="center" color="hover">https://github.com/Ruinedworm870</GlitchText>
                </Link>
            </div>
            
            <GlitchText size={40} bold align="center" color="title" style={{ marginTop: 50 }}>Featured Projects:</GlitchText>
            
            <Boxes
                data={featuredContentBoxes}
                boxWidth={350}
                gap={16}
                boxPadding={"10px 5px"}
                style={{
                    marginTop: 20
                }}
            />
        </div>
    )
}
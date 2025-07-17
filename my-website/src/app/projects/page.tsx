import Boxes, { BoxesType } from "@/components/containers/Boxes";
import GlitchText from "@/components/text/GlitchText";

export default function Projects()
{
    const projectBoxes: BoxesType = [
        {
            image: "/images/SpacePrivateerIcon.png",
            title: "Space Privateer",
            text: "My first game jam game",
            link: "/projects/space-privateer"
        },
        {
            image: "/images/API.png",
            title: "About Me Website",
            text: "",
            link: "/projects/about-me-website"
        },
        {
            image: "/images/TechEmpireTycoon.png",
            title: "Tech Empire Tycoon",
            text: "My third mobile game currently in development",
            link: "/projects/tech-empire-tycoon"
        },
        {
            image: "/images/AutomationArmsFactory.png",
            title: "Automation Arms Factory",
            text: "My second mobile game",
            link: "/projects/automation-arms-factory"
        },
        {
            image: "/images/ArmyStrategyIdleGame.png",
            title: "Army Strategy: Idle Game",
            text: "My first mobile game",
            link: "/projects/army-strategy-idle-game"
        },
        {
            image: "/images/coding.png",
            title: "College Programs",
            text: "Contains all of the programs I wrote in college",
            link: "/projects/college-programs"
        },
        {
            image: "/images/ApocalypseCommander.png",
            title: "Apocalypse Commander",
            text: "Unfinished Unity PC game",
            link: "/projects/apocalypse-commander"
        }
    ];
    
    return (
        <div
            style={{
                padding: "25px 15px"
            }}
        >
            <GlitchText color="title" size={64} bold align="center">My Projects</GlitchText>
            
            <Boxes
                data={projectBoxes}
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
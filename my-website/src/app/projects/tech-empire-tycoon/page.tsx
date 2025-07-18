import GlitchText from "@/components/text/GlitchText"
import { Paragraph, TextBlock } from "@/components/text/TextBlock"
import TechEmpireTycoonIFrame from "./TechEmpireTycoonIFrame"

export default function TechEmpireTycoon() {
    return (
        <div
            style={{
                padding: "25px 15px"
            }}
        >
            <GlitchText color="title" size={64} bold align="center">Tech Empire Tycoon</GlitchText>

            <TextBlock
                style={{
                    marginTop: 25
                }}
            >
                <Paragraph>
                    Tech Empire Tycoon is the third mobile game I have worked on, and is currently in development. It's completely different than the rest of my games because I'm building it with React Native and Expo instead of Unity. I wanted to build it with React Native because it's a lot easier to code UI with React than in Unity, and the game is entirely UI menu based. 
                </Paragraph>
                <Paragraph>
                    I have a playable version available on Itch.io linked below. I'm trying to take this game more seriously than my previous games and I'm attempting to gather feedback to shape the development of the game.
                </Paragraph>
            </TextBlock>

            <div
                style={{
                    width: "fit-content",
                    margin: "25px auto"
                }}
            >
                <TechEmpireTycoonIFrame />
            </div>
        </div>
    )
}
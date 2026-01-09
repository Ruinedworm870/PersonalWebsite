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
                    Tech Empire Tycoon is the third mobile game I have worked on, and is currently in development. It's completely different than the rest of my games because I'm building it with React Native and Expo instead of Unity. I wanted to build it with React Native because I think it's a lot easier to code UI with React than in Unity, and the game is entirely UI menu based. 
                </Paragraph>
                <Paragraph>
                    View the Itch.io link below for more information about the game including screenshots and information on how to play the game.
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
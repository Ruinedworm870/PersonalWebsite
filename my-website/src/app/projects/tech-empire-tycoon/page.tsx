import GlitchText from "@/components/text/GlitchText"
import { Paragraph, TextBlock } from "@/components/text/TextBlock"
import TechEmpireTycoonIFrame from "./TechEmpireTycoonIFrame"
import MainButton from "@/components/buttons/MainButton"
import MainText from "@/components/text/MainText"

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
                    Tech Empire Tycoon is the third mobile game I've worked on, and it's a bit different from my other projects. Instead of using Unity, I built it with React Native and Expo. I chose that stack because the game is entirely UI-driven, and React makes it much faster and more intuitive to build and manage interface-heavy systems.
                </Paragraph>
                <Paragraph>
                    The game itself is a simple offline idle business game. The player builds up tech companies over time to earn more money and unlock better companies. It is designed to be easy to pick up, with steady progression and clear feedback through the UI.
                </Paragraph>
                <Paragraph>
                    During development, I shared early versions and observed how people actually played. That made it clear where players got confused or slowed down, which I used to refine the UI, rebalance progression, and simplify systems so the game felt more intuitive without explanation.
                </Paragraph>
                <Paragraph>
                    This project gave me a lot of experience working outside of Unity and reinforced my ability to build clean, functional UI systems.
                </Paragraph>
                <Paragraph>
                    Below is the link to the Google Play Store page.
                </Paragraph>
            </TextBlock>
            
            <MainButton
                href={"https://play.google.com/store/apps/details?id=com.ruinedworm870.ClickerGame"}
            >
                <MainText align="center" size={28} bold>Play Store Link</MainText>
            </MainButton>

            {/*<div
                style={{
                    width: "fit-content",
                    margin: "25px auto"
                }}
            >
                <TechEmpireTycoonIFrame />
            </div>*/}
        </div>
    )
}
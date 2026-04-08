import MainButton from "@/components/buttons/MainButton"
import GlitchText from "@/components/text/GlitchText"
import MainText from "@/components/text/MainText"
import { Paragraph, TextBlock } from "@/components/text/TextBlock"

export default function ArmyStrategyIdleGame() {
    return (
        <div
            style={{
                padding: "25px 15px"
            }}
        >
            <GlitchText color="title" size={64} bold align="center">Army Strategy: Idle Game</GlitchText>

            <TextBlock
                style={{
                    marginTop: 25
                }}
            >
                <Paragraph>
                    Army Strategy: Idle Game is the first game I built using Unity and C#. It was a learning-focused project that gave me the foundation I used to significantly improve my second game.
                </Paragraph>
                <Paragraph>
                    The systems in this game are relatively simple, but I still implemented several key features. I integrated Google Play Games for leaderboards, achievements, and cloud saving, along with IronSource for ads. The underlying calculations are not especially complex, but I spent a lot of time experimenting with them, especially later in development as my understanding improved.
                </Paragraph>
                <Paragraph>
                    The biggest issue with this project was a lack of clear direction. I did not have a well-defined vision for what the game should be, which led to scope creep and slowed development significantly. Combined with the fact that I was learning the entire development process at the same time, this made the project take much longer than it should have.
                </Paragraph>
                <Paragraph>
                    In the end, I pushed it to completion mainly to move on, which resulted in a final product I was not fully satisfied with. However, that experience was the most valuable part of the project, as it directly influenced how I approached planning and development in later games.
                </Paragraph>
            </TextBlock>
            
            <MainText align="center" size={18} style={{ width: "85%", margin: "50px auto 25px auto" }} bold>The game is no longer available on Google Play because my Google Play Games Developer account was closed due to inactivity, but it can still be downloaded from the link below.</MainText>
        
            <MainButton
                href={"/downloads/ASIG_V_1.0.3.apk"}
            >
                <MainText align="center" size={28} bold>Download</MainText>
            </MainButton>
        </div>
    )
}
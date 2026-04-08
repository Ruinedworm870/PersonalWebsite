import GlitchText from "@/components/text/GlitchText"
import MainText from "@/components/text/MainText"
import { Paragraph, TextBlock } from "@/components/text/TextBlock"
import SpacePrivateerIFrame from "./SpacePrivateerIframe"
import MainButton from "@/components/buttons/MainButton"

export default function SpacePrivateer()
{
    return (
        <div
            style={{
                padding: "25px 15px"
            }}
        >
            <GlitchText color="title" size={64} bold align="center">Space Privateer</GlitchText>
        
            <TextBlock
                style={{
                    marginTop: 25
                }}
            >
                <Paragraph>
                    Space Privateer is my first ever game jam game, and my first finished game on PC. The game jam was the July 2024 Pirate Software Game Jam with a theme of Shadows and Alchemy with a 2 week duration.
                </Paragraph>
                <Paragraph>
                    I developed the entire game solo within that timeframe. Some other entries were more visually polished, often built by teams of up to five, but my focus was on delivering a complete and functional experience on my own. My strengths are mainly in programming, so visual and audio design were the areas I had to push myself the most.
                </Paragraph>
                <Paragraph>
                    The core structure is simple. There is an upgrade screen between rounds, and the main gameplay is wave-based combat where the player survives as long as possible. I implemented enemy AI to support that loop, which was relatively straightforward given the scope. The more demanding work came from building and connecting the UI systems and making sure they worked correctly with gameplay data when transitioning into battles.
                </Paragraph>
                <Paragraph>
                    Given the two week limit, the level of polish surprised me. The game runs reliably and the core systems are stable. There are still areas that could be improved, especially code organization, which became less clean toward the end as development sped up. Even so, the overall structure is solid and easy to work with if expanded further.
                </Paragraph>
            </TextBlock>
                
            <MainText align="center" size={18} style={{ marginTop: 50 }} bold>The full source code is available on GitHub, along with a playable build on itch.io.</MainText>
            
            <MainButton
                href={"https://github.com/Ruinedworm870/July-2024-Pirate-Software-Game-Jam"}
            >
                <MainText align="center" size={28} bold>GitHub</MainText>
            </MainButton>
            
            <div
                style={{
                    width: "fit-content",
                    margin: "25px auto"
                }}
            >
                <SpacePrivateerIFrame />
            </div>
        </div>
    )
}
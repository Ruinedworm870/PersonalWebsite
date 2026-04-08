import MainButton from "@/components/buttons/MainButton"
import GlitchText from "@/components/text/GlitchText"
import MainText from "@/components/text/MainText"
import { Paragraph, TextBlock } from "@/components/text/TextBlock"

export default function AutomationArmsFactory() {
    return (
        <div
            style={{
                padding: "25px 15px"
            }}
        >
            <GlitchText color="title" size={64} bold align="center">Automation Arms Factory</GlitchText>

            <TextBlock
                style={{
                    marginTop: 25
                }}
            >
                <Paragraph>
                    Automation Arms Factory was the second game I built using C# and Unity. I applied what I learned from my first project and completed this one in under two months.
                </Paragraph>
                <Paragraph>
                    This project is more technically advanced than my first. I integrated Google Play Games for achievements, leaderboards, and cloud saving, along with IronSource for ads. More importantly, I put significantly more effort into planning and system design.
                </Paragraph>
                <Paragraph>
                    Before development, I spent time defining the core gameplay and structuring systems so they could be extended or modified later. That upfront planning made a noticeable difference compared to my first game, where I had very little structure going in.
                </Paragraph>
                <Paragraph>
                    I also introduced multithreading to improve performance. Saving data became a bottleneck due to the increased amount of game state, which caused noticeable pauses. Moving that work off the main thread resolved the issue and made the game feel much smoother.
                </Paragraph>
                <Paragraph>
                    One of the more complex systems was item movement within the factory. I went through several iterations to get it working reliably. The initial approach used a per-frame loop to move items between conveyor slots, but this caused visible stuttering when items transitioned between conveyors. I replaced it with a system where each item controls its own movement. Each tile has a center collider that updates the item’s speed, direction, or destination as it passes through. The same system handles interactions with buildings, including spawning items, managing queues, and preventing overflow when output paths are blocked.
                </Paragraph>
                <Paragraph>
                    Another challenging part was calculating offline production and consumption. Since this runs without visible simulation, it required careful handling of edge cases and system states. The final implementation accounts for these scenarios and produces consistent results.
                </Paragraph>
            </TextBlock>
            
            <MainText align="center" size={18} style={{ width: "85%", margin: "50px auto 25px auto" }} bold>The game is no longer available on Google Play because my Google Play Games Developer account was closed due to inactivity, but it can still be downloaded from the link below.</MainText>
        
            <MainButton
                href={"/downloads/AAF_V_1.0.3.apk"}
            >
                <MainText align="center" size={28} bold>Download</MainText>
            </MainButton>
        </div>
    )
}
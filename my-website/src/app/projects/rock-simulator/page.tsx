import MainButton from "@/components/buttons/MainButton";
import GlitchText from "@/components/text/GlitchText";
import MainText from "@/components/text/MainText";
import { Paragraph, TextBlock } from "@/components/text/TextBlock";

export default function RockSimulator()
{
    return (
        <div
            style={{
                padding: "25px 15px"
            }}
        >
            <GlitchText color="title" size={64} bold align="center">Rock Simulator</GlitchText>

            <TextBlock
                style={{
                    marginTop: 25
                }}
            >
                <Paragraph>
                    Rock Simulator is my first completed Roblox game and primarily served as an introduction to multiplayer game development. Building it required working with Roblox's client-server model, which meant clearly separating logic between the server and client and deciding what data needed to be replicated, when, and how often.
                </Paragraph>
                <Paragraph>
                    This project forced me to think about networking from the start. I had to manage remote events, handle synchronization, and make sure gameplay remained consistent across multiple players while avoiding unnecessary data transfer. It also introduced constraints around security and trust, since the server has to validate important actions rather than relying on the client.
                </Paragraph>
                <Paragraph>
                    In the process, I learned Luau and gained a practical understanding of how multiplayer systems are structured and maintained. This experience carried over into how I think about architecture, data flow, and performance in other projects.
                </Paragraph>
                <Paragraph>
                    You will need a Roblox account to play the game using the link below.
                </Paragraph>
            </TextBlock>
            
            <MainButton
                href={"https://www.roblox.com/share?code=23c5339d705f054a88947a8643249681&type=ExperienceDetails&stamp=1752804517214"}
            >
                <MainText align="center" size={28} bold>Roblox Page</MainText>
            </MainButton>
        </div>
    )   
}
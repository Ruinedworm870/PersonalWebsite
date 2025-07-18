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
                    Rock Simulator is my first completed Roblox game. Before this game I was originally going to work on another Roblox game with a friend, but that never happened, so I decided to make my own game. If you look at the activity on my GitHub profile, the about 4 month period of nothing was when I was doing Roblox stuff. In that 4 month period I taught myself how to code in the Roblox Luau programming language, I then made this game and messed around with a couple other prototypes before deciding to start Tech Empire Tycoon.
                </Paragraph>
                <Paragraph>
                    With this project I learned a lot about making a multiplayer game. When making the game I had to handle server and client side code and handle what gets sent where, and when it gets sent. In the end it was really interesting and I learned a lot. I have a link to the game below, you will need a Roblox account to play the game.
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
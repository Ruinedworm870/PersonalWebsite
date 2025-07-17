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
                    I made the game entirely on my own in the 2 weeks and I think I did pretty good. There were definitely other submissions that looked better than mine, but given that I did it solo while it was allowed to work in teams of up to 5, I think I did alright. Also, I am much, much stronger at programming than making the game look or sound good, but I am getting better at making things look and sound good, and this game jam definitely helped.
                </Paragraph>
                <Paragraph>
                    The game is fairly basic where you have an out of battle upgrade screen and then the battles where you survive as many waves as possible. I had to make an enemy AI, which was pretty easy due to the simplicity of the game. The hardest part of the game was making it look and sound good, along with just the long process of connecting all the UI elements together and making that work with the data to load in the battles.
                </Paragraph>
                <Paragraph>
                    I'm surprised that the game is as polished as it is given the 2 week time frame. There are still some issues with it though that I would work on fixing if given more time, but from my testing at least code wise the game is really solid. Although the code is a little messy in some places, and would need some cleaning up if it were to be expanded, but that's because I started to rush in the last couple of days, but its really not that bad, at least for me to understand.
                </Paragraph>
            </TextBlock>
                
            <MainText align="center" size={18} style={{ marginTop: 50 }} bold>I have made all the code public on my GitHub which is linked below along with a link to the game on itch.io so you can play it.</MainText>
            
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
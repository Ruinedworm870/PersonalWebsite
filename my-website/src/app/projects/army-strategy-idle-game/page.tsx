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
                    Army Strategy: Idle game is the first game I made using Unity and C#. I learned a lot from making this game that allowed me to improve and make my second game much better.
                </Paragraph>
                <Paragraph>
                    There really isn't anything too advanced in this game. However, I did integrate Google Play Games into my game to have a leaderboard and achievements along with cloud saving which was a challenge, I also integrated IronSource for ads as well. The calculations behind the scenes in the game are also not extremely complex, but I did a lot of experimenting with them to try and find the best way of doing things, especially towards the end when I knew so much more than when I started.
                </Paragraph>
                <Paragraph>
                    There were a few mistakes I made when making this game. There was one major one that was an issue throughout development. The mistake was that I never had a clear picture on what I wanted the game to be. This was a major issue because I was learning about the whole process in general which took some time, but because I didn't quite have a clear plan, I was subject to scope creep which slowed down development and made it take forever to finish. In the end, I just decided to finish it to get it out because I just wanted to be done working on it, resulting in me not really liking the game. This was definitely the biggest mistake that I learned from, and it allowed my next game to be much better.
                </Paragraph>
            </TextBlock>

            <MainText align="center" size={18} style={{ width: "85%", margin: "50px auto 25px auto" }} bold>You can download the game from the link below, my Google Play Games Developer account has been closed due to inactivity, so the game is no longer available on Google Play</MainText>
        
            <MainButton
                href={"/downloads/ASIG_V_1.0.3.apk"}
            >
                <MainText align="center" size={28} bold>Download</MainText>
            </MainButton>
        </div>
    )
}
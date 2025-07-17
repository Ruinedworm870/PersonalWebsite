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
                    Automation Arms Factory was the second game I made using C# and Unity. I learned a lot from my first game and used that to make this one the best I could make it. I also made this one in less than 2 months.
                </Paragraph>
                <Paragraph>
                    There are more advanced things in this game than the last. However, like the last game I also integrated Google Play Games for achievements, leaderboards, and cloud saving. I also have IronSource integrated for ads. Some of the new things that are advanced in this game would be the planning and multithreading.
                </Paragraph>
                <Paragraph>
                    The planning that went into this game was much more in depth than my last game where I had hardly planned anything. For this game I spent quite some time thinking about what exactly I wanted the game to be like. I also spent time planning how I wanted each of the systems in the game to be made so that I could easily change them and add to them later. Now that I have it released in early access I can definitely say that I learned from my mistake of not planning in my first game, and I effectively planned for this game.
                </Paragraph>
                <Paragraph>
                    Also in this game I used multithreading to optimize it. I mainly just had to optimize saving because there is a lot more stuff to save in this game than the last, so it took quite a bit longer and was creating noticeable pauses which were fixed with multithreading.
                </Paragraph>
                <Paragraph>
                    I also had to create more advanced systems than my first game for things like the item movement in the factories. There were a lot of revisions I had to make to get the item movement in a good spot and there are probably some issues still in there now that I haven't found yet. I started by having an update loop run every frame and loop through each conveyor and move each item to the next slot if it was empty, but this created issues when the next conveyor came after the current conveyor, so the last item on the current conveyor would stop for a frame causing a jumpy look. In the end I settled for a system where each item handled moving itself using FixedUpdate and I added a collider at the center of each tile that will pass new data to the item when it reaches it. The data it passes will tell it the new speed, rotation, or if it is going to a building or not. Center of tile is also used to get items from buildings, if the center is clear it spawns the item, and if it isn't, it adds the item to a queue and will stop some new items going in to create room for the item in the queue.
                </Paragraph>
                <Paragraph>
                    I also had to calculate offline resource consumption and production which was also quite challenging, especially because I couldn't see what was happening like with the moving items. For the offline calculations I had to take into consideration a lot of possibilities which took some time and planning. In the end though I think I have quite a good system for calculating that.
                </Paragraph>
            </TextBlock>
            
            <MainText align="center" size={18} style={{ width: "85%", margin: "50px auto 25px auto"}} bold>You can download the game from the link below, my Google Play Games Developer account has been closed due to inactivity, so the game is no longer available on Google Play</MainText>
        
            <MainButton
                href={"/downloads/AAF_V_1.0.3.apk"}
            >
                <MainText align="center" size={28} bold>Download</MainText>
            </MainButton>
        </div>
    )
}
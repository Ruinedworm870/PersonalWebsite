import GlitchText from "@/components/text/GlitchText"
import { Paragraph, TextBlock } from "@/components/text/TextBlock"

export default function ApocalypseCommander() {
    return (
        <div
            style={{
                padding: "25px 15px"
            }}
        >
            <GlitchText color="title" size={64} bold align="center">Apocalypse Commander</GlitchText>

            <TextBlock
                style={{
                    marginTop: 25
                }}
            >
                <Paragraph>
                    Apocalypse Commander is the most advanced game that I have worked on. It is currently unfinished because I lost interest due to the amount content that I would need to create to make the game actually a game. It still deserves a spot on my projects page because I spent a lot of time working on the code and systems in the game. It didn't all go to waste just because I didn't finish the game, I still learned a lot from the work I did on it.
                </Paragraph>
                <Paragraph>
                    I have a private beta up on Steam where I distributed the keys to a couple friends. The game is a 2D top down RTS game where you control friendly soldiers fighting hordes of zombies. I created a little bit of the game outside of the "battles" including a map editor, but most of my time was spent making and optimizing the battles and just learning in general.
                </Paragraph>
                <Paragraph>
                    I started this project without much if any knowledge on creating a video game AI and pathfinding, now after this project I feel I have a solid understanding of the subject. I started the project by making it my priority to just learn how AI and pathfinding works, not necessarily doing it in the most efficient way possible. In the process I learned about and used A* and NavMeshes, just experimenting to find what would work. In the end for the zombie pathfinding, I had to come up with an entirely custom solution because it was too inefficient otherwise, for the friendly soldiers I used the A* Pathfinding Project Unity asset because I spent most of my time optimizing the zombies, and the asset was really efficient and easy to set up, though I did experiment with custom solutions, it was just taking a lot of time to make it efficient to support a bunch of friendly units.
                </Paragraph>
                <Paragraph>
                    The custom solution I used for the zombie pathfinding was a heat map. A heat map won't work well for a lot of other games, but mine had zombies, so the heat map was really good for creating the hordes of zombies. I also made it super efficient, it has such a tiny impact on performance, the only limiting factor to the number of zombies I could have at a single time was Unity's physics or any graphics processes, which I did my best to optimize both of those as much as I could. I limited the number of zombies to 3000 although it could have been higher from a performance standpoint, but from a gameplay perspective, it didn't need to be higher than that. The heat map worked by basically reading the surrounding tiles from the last update, getting the highest value, then setting it's value to that - 1, and it would be set to int.maxValue if a soldier was present. From there, there was another zombie process that ran that would read the results from that calculation which were used to calculate a direction to travel in for each individual zombie. I used the Unity C# Job System with burst compilation to multithread and perform all heat map related calculations, every so often the code to update the heat map will trigger and will perform all the necessary calculations and provide an updated NativeArray with all the values to each tile x and y mapped to an index in the flat array. For moving the zombies, the same method is used, it reads the heat map and outputs the direction that each zombie should move in to a NativeArray which is then read by the zombie in just a normal FixedUpdate to apply a move force. Targeting is another process that uses the Job System and burst compilation, both soldiers and zombies use targeting, soldiers use it to aim their weapons, basically looking in a radius around for zombies and aiming at the closest one in the line of sight, and zombies do the same thing when in a smaller range to just help them go directly to a target and not following the weird patterns that can sometimes be created by the heat map up close.
                </Paragraph>
                <Paragraph>
                    AI and pathfinding were the main things that I learned from this project, but I still learned a bunch of other new things and I further refined the skills I had before. I have included a gameplay clip below to just show the game since you can't play this one.
                </Paragraph>
            </TextBlock>
        
            <div
                style={{
                    marginTop: 50,
                    display: "flex",
                    justifyContent: "center",
                    paddingBottom: 200
                }}
            >
                <video width="640" height="360" controls>
                    <source src="/media/ApocalypseCommanderClip.mp4" type="video/mp4" />
                    Your browser does not support the video tag.
                </video>
            </div>
        </div>
    )
}
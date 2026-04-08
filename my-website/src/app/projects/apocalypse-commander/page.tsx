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
                    Apocalypse Commander is the most advanced project I've worked on. It is unfinished because I lost interest due to the amount of content required to turn it into a full game, but the systems and technical work make it worth including. A large portion of my time went into building and optimizing core systems, and the project significantly improved my understanding of AI, pathfinding, and performance.
                </Paragraph>
                <Paragraph>
                    The game is a 2D top-down RTS where the player controls soldiers fighting large hordes of zombies. I also built some supporting tools, including a basic map editor, but most of the work focused on the battle systems.
                </Paragraph>
                <Paragraph>
                    I started the project with little knowledge of AI or pathfinding and used it as a way to learn. I experimented with A* and NavMeshes, then moved toward more specialized solutions. For friendly units, I used the A* Pathfinding Project asset to save time and ensure efficiency. For zombies, I built a custom system because traditional approaches did not scale well for large hordes.
                </Paragraph>
                <Paragraph>
                    The zombie pathfinding is based on a heat map system. Each tile stores a value that guides movement, with higher values near targets and decreasing outward. Zombies read this data to determine their movement direction, which naturally creates large, cohesive hordes. The system is highly efficient and was designed to handle thousands of units at once.
                </Paragraph>
                <Paragraph>
                    All heat map calculations, movement direction updates, and targeting logic are handled using the Unity C# Job System with Burst compilation. These systems operate on NativeArrays and run in parallel, keeping the performance impact low. Zombies use the heat map for general movement, while both zombies and soldiers use a separate targeting system to identify targets and either aim or move toward the target.
                </Paragraph>
                <Paragraph>
                    The main limitation on unit count came from physics and rendering rather than pathfinding. I capped the number of zombies at 3000 for gameplay reasons, not performance constraints.
                </Paragraph>
                <Paragraph>
                    This project was primarily about building a deeper understanding of AI, pathfinding, and large-scale optimization. Even though it is not a finished game, the systems and techniques developed here were a major step forward.
                </Paragraph>
                <Paragraph>
                    A gameplay clip is included below since the project is not publicly playable.
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
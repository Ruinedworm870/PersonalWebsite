import MainButton from "@/components/buttons/MainButton";
import Boxes, { BoxesType } from "@/components/containers/Boxes";
import GlitchText from "@/components/text/GlitchText";
import MainText from "@/components/text/MainText";
import { Paragraph, TextBlock } from "@/components/text/TextBlock";

export default function About()
{
    const languageBoxes: BoxesType = [
        {
            image: "/images/CSharp.png",
            title: "C#",
            text: "",
            link: ""
        },
        {
            image: "/images/Java.png",
            title: "Java",
            text: "",
            link: ""
        },
        {
            image: "/images/Python.png",
            title: "Python",
            text: "",
            link: ""
        },
        {
            image: "/images/HTML.png",
            title: "HTML",
            text: "",
            link: ""
        },
        {
            image: "/images/CSS.png",
            title: "CSS",
            text: "",
            link: ""
        },
        {
            image: "/images/JS.png",
            title: "JavaScript",
            text: "",
            link: ""
        },
        {
            image: "/images/TypeScript.png",
            title: "TypeScript",
            text: "",
            link: ""
        },
        {
            image: "/images/PHP.png",
            title: "PHP",
            text: "",
            link: ""
        },
        {
            image: "/images/SQL.png",
            title: "SQL",
            text: "",
            link: ""
        },
        {
            image: "/images/Lua.png",
            title: "Lua",
            text: "",
            link: ""
        }
    ];
    
    const technologiesBoxes: BoxesType = [
        {
            image: "/images/Unity.png",
            title: "Unity",
            text: "",
            link: ""
        },
        {
            image: "/images/DotNetLogo.png",
            title: "ASP.NET Core",
            text: "",
            link: ""
        },
        {
            image: "/images/GitHub.png",
            title: "GitHub",
            text: "",
            link: ""
        },
        {
            image: "/images/AWS.png",
            title: "AWS",
            text: "",
            link: ""
        },
        {
            image: "/images/Flask.png",
            title: "Flask",
            text: "",
            link: ""
        },
        {
            image: "/images/React.png",
            title: "React",
            text: "",
            link: ""
        },
        {
            image: "/images/WordPress.png",
            title: "WordPress",
            text: "",
            link: ""
        },
        {
            image: "/images/NextJS.png",
            title: "Next.js",
            text: "",
            link: ""
        },
        {
            image: "/images/ChatGPT.png",
            title: "ChatGPT",
            text: "",
            link: ""
        }
    ];
    
    return (
        <div
            style={{
                padding: "25px 15px"
            }}
        >
            <GlitchText color="title" size={64} bold align="center">About Me</GlitchText>

            <GlitchText color="title" size={40} bold align="center" style={{ marginTop: 50 }}>Languages</GlitchText>
            <Boxes
                data={languageBoxes}
                boxWidth={158}
                imageSize={100}
                gap={15}
                boxPadding={"10px 5px"}
                style={{
                    marginTop: 20,
                }}
            />
            
            <GlitchText color="title" size={40} bold align="center" style={{ marginTop: 50 }}>Technologies</GlitchText>
            <Boxes
                data={technologiesBoxes}
                boxWidth={158}
                imageSize={100}
                gap={15}
                boxPadding={"10px 5px"}
                style={{
                    marginTop: 20,
                }}
            />

            <GlitchText color="title" size={40} bold align="center" style={{ marginTop: 50 }}>Background</GlitchText>
            <TextBlock>
                <Paragraph>
                    My name is William Smolinski Jr, but I prefer to be called Billy. I've been programming for over 6 years, starting with game development before expanding into full-stack web development. I still enjoy building games in my spare time because they constantly challenge me to learn new things and solve interesting problems.
                </Paragraph>
                <Paragraph>
                    I currently work as a Systems Analyst / Full-Stack Developer for Saratoga County, where I design, develop, and maintain internal web applications that improve day-to-day operations. My work covers the full development lifecycle, from gathering requirements and designing solutions to implementation, testing, and deployment.
                </Paragraph>
                <Paragraph>
                    I earned my Associate of Science in Computer Information Systems with a 4.0 GPA. Outside of work, I regularly build personal projects ranging from web applications to games. I try to learn something new with every project I build.
                </Paragraph>
            </TextBlock>
            
            <div style={{
                display: "flex",
                gap: 16,
                alignItems: "center",
            }}>
                <MainButton
                    href={"/pdfs/William_Smolinski_Game_Resume.pdf"}
                    additionalStyle={{
                        marginTop: 25,
                        marginRight: 0
                    }}
                >
                    <MainText size={32} align="center" bold>Game Development Resume</MainText>
                </MainButton>
                <MainButton
                    href={"/pdfs/William_Smolinski_Web_Resume.pdf"}
                    additionalStyle={{
                        marginTop: 25,
                        marginLeft: 0
                    }}
                >
                    <MainText size={32} align="center" bold>Web Development Resume</MainText>
                </MainButton>
            </div>
            
            
            <div style={{padding: 100}}></div>
        </div>
    )
}
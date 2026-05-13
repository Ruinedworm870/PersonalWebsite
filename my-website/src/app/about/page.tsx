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
                    My name is William Smolinski Jr, but I prefer to be called Billy. I have been coding for about 5 years now. I started out by learning to make games since I enjoyed playing them, and I still make them in my spare time. I then branched out into web development where I made this website before getting my current job. I actively maintain this site and it's currently in it's third version.
                </Paragraph>
                <Paragraph>
                    I have an Associates degree in Computer Information Systems. I graduated with a 4.0 GPA having completed about half in high school and the other half online the year after I graduated high school.
                </Paragraph>
                <Paragraph>
                    I have completed several projects and I'm always working on another. I mostly work on games as my projects since those are the most fun for me. With every project I always try and teach myself something new. Making the games has taught me a lot of skills that have helped me excel at web development and continue to help me excel at learning new things. I'm also skilled at using AI as a tool to accelerate my learning of new things.
                </Paragraph>
                <Paragraph>
                    I currently work for Saratoga County as a Systems Analyst where what I do is mostly full stack web development. I work both independently and in a small team. I am responsible for gathering requirements and running tests in addition to programming the applications. I have made several impactful applications for the county that have made the work of others more efficient.
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
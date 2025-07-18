import GlitchText from "@/components/text/GlitchText"
import MainText from "@/components/text/MainText"
import { GetCollegePrograms } from "./GetPrograms"
import Toggle from "@/components/containers/Toggle";
import Link from "next/link";

export default function CollegePrograms()
{
    const data = GetCollegePrograms();    
    
    return (
        <div
            style={{
                padding: "25px 15px"
            }}
        >
            <GlitchText color="title" size={64} bold align="center">College Programs</GlitchText>

            <MainText
                align="center"
                size={18}
                style={{
                    marginTop: 50
                }}
            >
                This showcases all of the programs that I wrote throughout college. There are about.txt files to view as the first option under each class to learn more about what each class was.
            </MainText>
            
            <div
                style={{
                    display: "flex",
                    flexDirection: "column",
                    width: "fit-content",
                    margin: "50px auto",
                    gap: 25
                }}
            >
                {data.map((cls, index) => (
                    <Toggle
                        key={index}
                        title={cls.className}
                        fontSize={28}
                        contentId={ index.toString() }
                    >
                        <div
                            style={{
                                marginLeft: 40,
                                display: "flex",
                                flexDirection: "column",
                                gap: 10,
                                marginTop: 10
                            }}
                        >
                            <Link
                                href={`/projects/college-programs/${cls.classCode}/about`}
                                target="_blank"
                                style={{
                                    textDecoration: "none",
                                    width: "fit-content"
                                }}
                            >
                                <MainText size={20} color="hover" style={{width: "fit-content"}}>About.txt</MainText>
                            </Link>
                            
                            {cls.projects.map((project, idx) => (
                                <Toggle
                                    key={idx}
                                    title={project.name}
                                    fontSize={20}
                                    parentId={index.toString()}
                                >
                                    <div
                                        style={{
                                            marginLeft: 40,
                                            display: "flex",
                                            flexDirection: "column",
                                            gap: 10,
                                            marginTop: 10
                                        }}
                                    >
                                        {project.files.map((file, i) => (
                                            <Link
                                                key={i}
                                                href={`/projects/college-programs/${cls.classCode}/${project.name}/${file}`}
                                                target="_blank"
                                                style={{
                                                    textDecoration: "none",
                                                    width: "fit-content"
                                                }}
                                            >
                                                <MainText size={18} color="hover" style={{ width: "fit-content" }}>{file}</MainText>
                                            </Link>
                                        ))}
                                    </div>
                                </Toggle>
                            ))}
                        </div>
                        
                    </Toggle>
                ))}
            </div>
            
            <div style={{padding: 100}}></div>
        </div>
    )
}
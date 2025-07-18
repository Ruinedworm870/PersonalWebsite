import MainButton from "@/components/buttons/MainButton"
import GlitchText from "@/components/text/GlitchText"
import MainText from "@/components/text/MainText"
import { Paragraph, TextBlock } from "@/components/text/TextBlock"

export default function AboutMeWebsite() {
    return (
        <div
            style={{
                padding: "25px 15px"
            }}
        >
            <GlitchText color="title" size={64} bold align="center">About Me Website</GlitchText>
        
            <TextBlock
                style={{
                    marginTop: 25
                }}
            >
                <Paragraph>
                    This is the third version of my website. The current version runs with Next.js hosted on an AWS EC2 instance. The original version of the site was made with plain html being served over a Flask API, and the second version of the site ran with php.
                </Paragraph>
                <Paragraph>
                    All of the code for the current version is public on my GitHub linked below. I have plans to expand the site, the progress of that is also public on my GitHub.
                </Paragraph>
            </TextBlock>
            
            <MainButton
                href={"https://github.com/Ruinedworm870/PersonalWebsite"}
            >
                <MainText align="center" size={28} bold>GitHub Repo</MainText>
            </MainButton>
        </div>
    )
}
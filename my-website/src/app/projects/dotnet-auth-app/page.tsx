import MainButton from "@/components/buttons/MainButton"
import GlitchText from "@/components/text/GlitchText"
import MainText from "@/components/text/MainText"
import { Paragraph, TextBlock } from "@/components/text/TextBlock"

export default function AuthApp() {
    return (
        <div
            style={{
                padding: "25px 15px"
            }}
        >
            <GlitchText color="title" size={64} bold align="center">.NET Authentication API</GlitchText>

            <TextBlock
                style={{
                    marginTop: 25
                }}
            >
                <Paragraph>
                    A .NET Web API project demonstrating authentication, authorization, role management, and automated testing.
                </Paragraph>
                <Paragraph>
                    This project focuses on authentication and authorization architecture using ASP.NET Core Identity and PostgreSQL.
                </Paragraph>
                <Paragraph>
                    It includes account registration, login, role based access control, protected endpoints, administrative role management, and account deletion.
                </Paragraph>
                <Paragraph>
                    Authorization logic includes database backed policy validation so access changes can take effect immediately rather than waiting for token expiration.
                </Paragraph>
                <Paragraph>
                    The project also includes automated integration tests covering authentication and authorization behavior.
                </Paragraph>
            </TextBlock>

            <MainButton
                href={"https://github.com/Ruinedworm870/.NET-AuthApp"}
            >
                <MainText align="center" size={28} bold>GitHub Repo</MainText>
            </MainButton>
        </div>
    )
}
import MainButton from "@/components/buttons/MainButton"
import GlitchText from "@/components/text/GlitchText"
import MainText from "@/components/text/MainText"
import { Paragraph, TextBlock } from "@/components/text/TextBlock"

export default function ReportGenerator() {
    return (
        <div
            style={{
                padding: "25px 15px"
            }}
        >
            <GlitchText color="title" size={64} bold align="center">.NET Report Generator</GlitchText>

            <TextBlock
                style={{
                    marginTop: 25
                }}
            >
                <Paragraph>
                    A .NET Web API project demonstrating asynchronous background processing, database backed job queues, and integration testing.
                </Paragraph>
                <Paragraph>
                    This project simulates asynchronous report generation using ASP.NET Core background workers and PostgreSQL backed job tracking.
                </Paragraph>
                <Paragraph>
                    Clients submit report requests through API endpoints, where jobs are stored with processing states such as pending, completed, or failed. A background worker processes queued jobs on an interval, generates reports from order data, and updates job status accordingly.
                </Paragraph>
                <Paragraph>
                    The goal of this project was to demonstrate backend architecture patterns commonly used in production systems, including background processing, database persistence, API design, and automated integration testing.
                </Paragraph>
            </TextBlock>

            <MainButton
                href={"https://github.com/Ruinedworm870/.NET-ReportGenerator"}
            >
                <MainText align="center" size={28} bold>GitHub Repo</MainText>
            </MainButton>
        </div>
    )
}
import GlitchText from '@/components/text/GlitchText';
import { Colors } from '@/hooks/Colors';
import fs from 'fs';
import path from 'path';

export function generateStaticParams()
{
    const data: { className: string, program: string, file: string }[] = [];
    
    const programsDir = path.join(process.cwd(), 'src', 'data');
    const classes = fs.readdirSync(programsDir, { withFileTypes: true });

    for (const cls of classes)
    {
        const classCode = cls.name.slice(-7);
        const classPath = path.join(programsDir, cls.name);
        
        const programs = fs.readdirSync(classPath, { withFileTypes: true }).filter(entry => entry.isDirectory());

        for (const program of programs)
        {
            const programName = program.name;
            const programPath = path.join(classPath, programName);

            const files = fs.readdirSync(programPath, { withFileTypes: true });

            for (const file of files)
            {
                data.push({
                    className: classCode,
                    program: programName,
                    file: file.name
                });
            }
        }
    }

    return data;
}

export default async function ProgramFilePage({params}: {params: Promise<{className: string, program: string, file: string}>})
{
    const { className, program, file } = await params;

    const programsDir = path.join(process.cwd(), 'src', 'data');
    const cls = fs.readdirSync(programsDir, { withFileTypes: true }).filter(cls => cls.name.endsWith(className))[0];

    const filePath = path.join(programsDir, cls.name, program, file);

    const fileContent = fs.readFileSync(filePath, 'utf-8');

    return (
        <div
            style={{
                padding: "25px 15px"
            }}
        >
            <GlitchText color="title" size={64} bold align="center">{ file }</GlitchText>

            <div
                style={{
                    width: "85%",
                    margin: "25px auto",
                    paddingBottom: 200,
                    color: Colors.text
                }}
            >
                <pre style={{ whiteSpace: 'pre-wrap' }}>{fileContent}</pre>
            </div>
        </div>
    )
}
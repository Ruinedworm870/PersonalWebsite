import GlitchText from '@/components/text/GlitchText';
import { Colors } from '@/hooks/Colors';
import fs from 'fs';
import path from 'path';

export function generateStaticParams()
{
    const programsDir = path.join(process.cwd(), 'src', 'data');
    const classes = fs.readdirSync(programsDir, { withFileTypes: true });
    
    return classes.map(cls => {
        return {
            className: cls.name.slice(-7)
        }
    })
}

export default async function AboutPage({ params }: { params: Promise<{ className: string}>})
{
    const { className } = await params;
    
    const programsDir = path.join(process.cwd(), 'src', 'data');
    const cls = fs.readdirSync(programsDir, { withFileTypes: true }).filter(cls => cls.name.endsWith(className))[0];
    const aboutPath = path.join(programsDir, cls.name, 'about.txt');
    
    const aboutText = fs.readFileSync(aboutPath, 'utf-8');
    
    return (
        <div
            style={{
                padding: "25px 15px"
            }}
        >
            <GlitchText color="title" size={64} bold align="center">About {className}</GlitchText>
            
            <div
                style={{
                    width: "85%",
                    margin: "25px auto",
                    paddingBottom: 200,
                    color: Colors.text
                }}
            >
                <pre style={{ whiteSpace: 'pre-wrap' }}>{ aboutText }</pre>
            </div>
        </div>
    )
}
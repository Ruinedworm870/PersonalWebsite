import fs from 'fs';
import path from 'path';

export const GetCollegePrograms = () =>
{
    const programsDir = path.join(process.cwd(), 'src', 'data');
    const classes = fs.readdirSync(programsDir, { withFileTypes: true });

    const data = classes.map(cls =>
    {
        const classPath = path.join(programsDir, cls.name);
        const aboutPath = path.join(classPath, 'about.txt');

        const classCode = cls.name.slice(-7);

        const projects = fs.readdirSync(classPath, { withFileTypes: true }).filter(entry => entry.isDirectory()).map(project =>
        {
            const projectPath = path.join(classPath, project.name);
            const files = fs.readdirSync(projectPath);

            return {
                name: project.name,
                files
            }
        });

        return {
            className: cls.name,
            aboutPath,
            projects,
            classCode
        }
    });

    return data;
}
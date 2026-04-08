// AI Auto Debugger Module
const OpenAI = require("openai");
const client = new OpenAI({ apiKey: process.env.OPENAI_API_KEY });

async function fixCode(code) {
  const response = await client.chat.completions.create({
    model: "gpt-5",
    messages: [
      {
        role: "user",
        content: `Fix errors in this React code and optimize it:\n${code}`
      }
    ]
  });

  return response.choices[0].message.content;
}

module.exports = { fixCode };
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.dashscope.QwenChatModel;
import dev.langchain4j.service.AiServices;


import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        String apikey = "sk-0d6802afeedb46019660e83e756948fd";
        //创建一个输入器对象
        Scanner scanner = new Scanner(System.in);
        ChatLanguageModel model =
                QwenChatModel.builder()
                        .apiKey(apikey)
                        .modelName("qwen-plus")
                        .build();
        Role xh = AiServices.builder(Role.class)
                .chatLanguageModel(model)
                .chatMemory(MessageWindowChatMemory.withMaxMessages(20))
                .build();

        while (true){
            System.out.println("Please enter your api key:");
            //使用输入器等待用户输入内容
            String message = scanner.nextLine();
            String replay = xh.chat(message);
            System.out.println("AI:"+replay);
        }
    }
}

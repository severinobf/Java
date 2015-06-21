
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author weverton
 */
public class ProcessStepMock {

    public static void main(String[] args) {

        String grupo = "management";
        String responsavel = "kermit";
        String solicitante = "kermit";

        ProcessEngine processEngine;
        RepositoryService repositoryService;
        RuntimeService runtimeService;
        TaskService taskService;
        
         
        processEngine = ProcessEngines.getDefaultProcessEngine();

        repositoryService = processEngine.getRepositoryService();
        repositoryService.createDeployment().addClasspathResource("ProcessoSolicitaAparelhos.bpmn20.xml").deploy();

        System.out.println("Number of process definitions: " + repositoryService.createProcessDefinitionQuery().count());

        Map<String, Object> variables = new HashMap<>();
        variables.put("assignee", solicitante);
        variables.put("approver", responsavel);
        variables.put("idProcesso", "123");
        variables.put("duedate", "123");
        variables.put("dataDeVencimentoComodato", "123");
        variables.put("pessoaSolicitante", "123");
        variables.put("motivoDeCompra", "123");
        variables.put("pessoaDestinataria", solicitante);
        variables.put("grupo", "123");
        variables.put("idAparelhoOuServico", "123");
        variables.put("descricaoAparelhoOuServico", "123");
        variables.put("caminhoDoDocumentoAnexo", "123");
        variables.put("status", "123");
        variables.put("nomeOperadora", "123");
        variables.put("tenant", "123");
        variables.put("approved","true");
       
        runtimeService = processEngine.getRuntimeService();
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("processoSolicitaAparelhos", variables);

        System.out.println("Process Activity ID: " + processInstance.getActivityId());

        // Verify that we started a new process instance
        System.out.println("Number of process instances: " + runtimeService.createProcessInstanceQuery().count());

        // Fetch all tasks for the management group
        taskService = processEngine.getTaskService();
        List<Task> tasks = taskService.createTaskQuery().taskAssignee(solicitante).list();
        for (Task task : tasks) {
            System.out.println("Task available: " + task.getName());
            System.out.println("Task id: " + task.getId());
        }
    }
}

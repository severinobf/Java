
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
public class ProcessStepImpl {

    private ProcessEngine processEngine;
    private RepositoryService repositoryService;
    private RuntimeService runtimeService;
    private TaskService taskService;
    private ProcessInstance processInstance;

    public void startProcess(String processName) {

        // -- Inicia processo --
        processEngine = ProcessEngines.getDefaultProcessEngine();

        repositoryService = processEngine.getRepositoryService();
        repositoryService.createDeployment().addClasspathResource(processName).deploy();

        System.out.println("Number of process definitions: " + repositoryService.createProcessDefinitionQuery().count());
    }

    public void startTask(String taskName, ProcessStepTO processStepTO) {

        Map<String, Object> variables = new HashMap<>();
        variables.put("assignee", processStepTO.getAssignee());
        variables.put("approver", processStepTO.getApprover());
        variables.put("idProcesso", processStepTO.getIdProcesso());
        variables.put("duedate", processStepTO.getDuedate());
        variables.put("dataDeVencimentoComodato", processStepTO.getDataDeVencimentoComodato());
        variables.put("pessoaSolicitante", processStepTO.getPessoaSolicitante());
        variables.put("motivoDeCompra", processStepTO.getMotivoDeCompra());
        variables.put("pessoaDestinataria", processStepTO.getPessoaDestinataria());
        variables.put("grupo", processStepTO.getGrupo());
        variables.put("idAparelhoOuServico", processStepTO.getIdAparelhoOuServico());
        variables.put("descricaoAparelhoOuServico", processStepTO.getDescricaoAparelhoOuServico());
        variables.put("caminhoDoDocumentoAnexo", processStepTO.getCaminhoDoDocumentoAnexo());
        variables.put("status", processStepTO.getStatus());
        variables.put("nomeOperadora", processStepTO.getNomeOperadora());
        variables.put("tenant", processStepTO.getTenant());
        variables.put("approved", processStepTO.getApproved());

        runtimeService = processEngine.getRuntimeService();
        processInstance = runtimeService.startProcessInstanceByKey(taskName, variables);

        System.out.println("Process Activity ID: " + processInstance.getActivityId());
        // Verify that we started a new process instance
        System.out.println("Number of process instances: " + runtimeService.createProcessInstanceQuery().count());

    }

    public List<Task> taskList(ProcessStepTO processStepTO) {

        // Fetch all tasks for the management group
        taskService = processEngine.getTaskService();
        List<Task> tasks = taskService.createTaskQuery().taskAssignee(processStepTO.getAssignee()).list();
        for (Task task : tasks) {
            System.out.println("Task available: " + task.getName());
            System.out.println("Task id: " + task.getId());
        }
        return tasks;
    }
}

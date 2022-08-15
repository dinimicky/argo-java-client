/*
 * Argo Server API
 * You can get examples of requests and responses by using the CLI with `--gloglevel=9`, e.g. `argo list --gloglevel=9`
 *
 * The version of the OpenAPI document: v2.12.2
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package io.argoproj.workflow.apis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import io.argoproj.workflow.ApiCallback;
import io.argoproj.workflow.ApiException;
import io.argoproj.workflow.JSON;
import io.argoproj.workflow.component.model.Component;
import io.argoproj.workflow.component.model.ComponentGraph;
import io.argoproj.workflow.component.model.ComponentInstance;
import io.argoproj.workflow.models.Arguments;
import io.argoproj.workflow.models.DAGTask;
import io.argoproj.workflow.models.DAGTemplate;
import io.argoproj.workflow.models.Inputs;
import io.argoproj.workflow.models.NodeStatus;
import io.argoproj.workflow.models.Outputs;
import io.argoproj.workflow.models.Parameter;
import io.argoproj.workflow.models.RetryStrategy;
import io.argoproj.workflow.models.StreamResultOfWorkflowWatchEvent;
import io.argoproj.workflow.models.Template;
import io.argoproj.workflow.models.ValueFrom;
import io.argoproj.workflow.models.Workflow;
import io.argoproj.workflow.models.WorkflowCreateRequest;
import io.argoproj.workflow.models.WorkflowSpec;
import io.argoproj.workflow.models.WorkflowStatus;
import io.kubernetes.client.openapi.models.V1Container;
import io.kubernetes.client.openapi.models.V1ObjectMeta;
import okhttp3.Response;
import okio.BufferedSource;
import org.apache.commons.lang3.StringUtils;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleDirectedGraph;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * API tests for WorkflowServiceApi
 */
@Ignore
public class WfGraphTest {

    private final WorkflowServiceApi api = new WorkflowServiceApi();

    @Before
    public void initTest() {
        api.getApiClient().setBasePath("https://localhost:2746");
        api.getApiClient().setLenientOnJson(true);
    }

    /**
     * @throws ApiException if the Api call fails
     */
    @Test
    public void createWorkflowTest() throws ApiException {
        String namespace = "argo";
        WorkflowCreateRequest body = new WorkflowCreateRequest();
        body.setServerDryRun(false); // if true, not create real wf
        body.setNamespace(namespace);
        body.setWorkflow(new Workflow());
        V1ObjectMeta metadata = new V1ObjectMeta();
        body.getWorkflow().setMetadata(metadata);
        metadata.setGenerateName("demo-hello-world-");
        metadata.setNamespace(namespace);
        Map<String, String> labels = new HashMap<>();
        metadata.setLabels(labels);
        labels.put("workflows.argoproj.io/completed", "false");

        String tmplName = "whalesay";
        String dagTmplName = "dag-demo";
        WorkflowSpec spec = new WorkflowSpec();
        body.getWorkflow().setSpec(spec);
        List<Template> templates = new ArrayList<>();
        spec.setTemplates(templates);

        Template tmpl = new Template();
        templates.add(tmpl);
        tmpl.setName(tmplName);
        Inputs inputs = new Inputs();
        tmpl.setInputs(inputs);
        Parameter parameter = new Parameter();
        parameter.setName("msg");
        inputs.setParameters(Arrays.asList(parameter));
        V1Container container = new V1Container();
        tmpl.setContainer(container);
        container.setImage("docker/whalesay:latest");
        container.setCommand(Arrays.asList("cowsay"));
        container.setArgs(Arrays.asList("{{inputs.parameters.msg}}"));

        String failureTmplName = "retry-container";
        Template retryTmpl = new Template();
        templates.add(retryTmpl);
        retryTmpl.setName(failureTmplName);
        V1Container retryContainer = new V1Container();
        retryTmpl.setContainer(retryContainer);
        retryContainer.setImage("python:alpine3.6");
        retryContainer.setCommand(Arrays.asList("python", "-c"));
        retryContainer.setArgs(
            Arrays.asList("import random; import sys; exit_code = random.choice([0, 1]);sys.exit(exit_code)"));
        RetryStrategy retryStrategy = new RetryStrategy();
        retryTmpl.setRetryStrategy(retryStrategy);
        retryStrategy.setLimit(10);

        Template dagTmpl = new Template();
        templates.add(dagTmpl);
        DAGTemplate dag = new DAGTemplate();
        dagTmpl.setDag(dag);
        dagTmpl.setName(dagTmplName);
        DAGTask dagTaskA = buildDAGTask(dagTmplName, "A", tmplName);
        dagTaskA.setArguments(new Arguments());
        Parameter dagTaskAArg = new Parameter();
        dagTaskAArg.setName("msg");
        dagTaskAArg.setValue("hello arg A");
        dagTaskA.getArguments().setParameters(Arrays.asList(dagTaskAArg));
        DAGTask dagTaskB = buildDAGTask(dagTmplName, "B", failureTmplName);
        DAGTask dagTaskC = buildDAGTask(dagTmplName, "C", tmplName);
        dagTaskC.setArguments(new Arguments());
        Parameter dagTaskCArg = new Parameter();
        dagTaskC.getArguments().setParameters(Arrays.asList(dagTaskCArg));
        dagTaskCArg.setName("msg");
        dagTaskCArg.setValue("hello arg C");
        dagTaskC.setDependencies(Arrays.asList(dagTaskA.getName(), dagTaskB.getName()));
        dag.setTasks(Arrays.asList(dagTaskA, dagTaskB, dagTaskC));
        spec.setEntrypoint(dagTmpl.getName());

        System.out.println(body);
        Workflow response = api.createWorkflow(namespace, body);
        System.out.println(response);

        // TODO: test validations
    }

    private DAGTask buildDAGTask(String prefix, String name, String templateName) {
        DAGTask dagTask = new DAGTask();
        dagTask.setName(prefix + "-" + name);
        dagTask.setTemplate(templateName);
        return dagTask;
    }

    private DAGTask buildDAGTask(ComponentInstance componentInstance) {
        DAGTask dagTask = new DAGTask();
        dagTask.setName(componentInstance.getId());
        dagTask.setTemplate(componentInstance.getComponent().getName());
        return dagTask;
    }

    /**
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getWorkflowTest() throws ApiException {
        String namespace = "argo";
        String name = "demo-hello-world-tfts5";
        String getOptionsResourceVersion = null;
        String fields = null;
        //Workflow response = api.getWorkflow(namespace, name, getOptionsResourceVersion, fields);
        Workflow wf = api.getWorkflow(namespace, name, null, null);
        JSON json = new JSON();
        System.out.println(json.serialize(wf));

        Map<String, Template> map = new HashMap<>();
        for (Template template : wf.getSpec().getTemplates()) {
            map.put(template.getName(), template);
        }

        Graph<String, DefaultEdge> g = new SimpleDirectedGraph<>(DefaultEdge.class);
        for (Entry<String, NodeStatus> entry : Optional.ofNullable(wf.getStatus()).map(WorkflowStatus::getNodes).orElse(
            Collections.emptyMap()).entrySet()) {
            NodeStatus status = entry.getValue();
            System.out.println(
                String.format("%s:%s:%s:%s:%s:%s:%s %s %s", entry.getKey(), status.getName(), status.getId(),
                    status.getPhase(), status.getChildren(), status.getBoundaryID(), status.getOutboundNodes(),
                    status.getStartedAt(), status.getFinishedAt()));
            g.addVertex(entry.getKey());
            for (String key : Optional.ofNullable(entry.getValue()).map(NodeStatus::getChildren).orElse(
                Collections.emptyList())) {
                g.addVertex(key);
                g.addEdge(entry.getKey(), key);
            }
        }
        System.out.println(g);

        Graph<NodeStatus, DefaultEdge> g2 = new SimpleDirectedGraph<>(DefaultEdge.class);
        for (Entry<String, NodeStatus> entry : Optional.ofNullable(wf.getStatus()).map(WorkflowStatus::getNodes).orElse(
            Collections.emptyMap()).entrySet()) {
            NodeStatus status = entry.getValue();
            System.out.println(
                String.format("%s:%s:%s:%s:%s:%s:%s %s %s", entry.getKey(), status.getName(), status.getId(),
                    status.getPhase(), status.getChildren(), status.getBoundaryID(), status.getOutboundNodes(),
                    status.getStartedAt(), status.getFinishedAt()));
            g2.addVertex(entry.getValue());
            for (String key : Optional.ofNullable(entry.getValue()).map(NodeStatus::getChildren).orElse(
                Collections.emptyList())) {
                NodeStatus child = wf.getStatus().getNodes().get(key);
                g2.addVertex(child);
                g2.addEdge(entry.getValue(), child);
            }
        }
        System.out.println(g2);

    }

    /**
     * @throws ApiException if the Api call fails
     */
    @Test
    public void watchWorkflowsTest() throws IOException {

        String namespace = "argo";
        String listOptionsLabelSelector = null;
        String listOptionsFieldSelector = null;
        Boolean listOptionsWatch = null;
        Boolean listOptionsAllowWatchBookmarks = null;
        String listOptionsResourceVersion = "0";
        String listOptionsTimeoutSeconds = null;
        String listOptionsLimit = "1";
        String listOptionsContinue = "";
        try {
            ApiCallback<StreamResultOfWorkflowWatchEvent> cb = new ApiCallback<StreamResultOfWorkflowWatchEvent>() {
                @Override
                public void onFailure(ApiException e, int statusCode, Map<String, List<String>> responseHeaders) {

                }

                @Override
                public void onSuccess(StreamResultOfWorkflowWatchEvent result, int statusCode,
                    Map<String, List<String>> responseHeaders) {
                    System.out.println("result:" + result);
                }

                @Override
                public void onUploadProgress(long bytesWritten, long contentLength, boolean done) {

                }

                @Override
                public void onDownloadProgress(long bytesRead, long contentLength, boolean done) {

                }
            };
            okhttp3.Call res = api.watchWorkflowsCall(namespace, listOptionsLabelSelector, listOptionsFieldSelector,
                listOptionsWatch, listOptionsAllowWatchBookmarks, listOptionsResourceVersion, listOptionsTimeoutSeconds,
                listOptionsLimit, listOptionsContinue, cb);

            if (res.isExecuted()) {

                System.out.println(res);
            } else {
                try (Response response = res.execute()) {
                    BufferedSource source = response.body().source();
                    for (int i = 1; !source.exhausted(); i++) {
                        System.out.println(i + ":" + source.readUtf8Line());
                    }

                }
            }

        } catch (ApiException e) {
            System.err.println("Exception when calling WorkflowServiceApi#watchWorkflows");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }

    }

    @Test
    public void testComponent() throws ApiException {
        Component cfg1 = buildConfComponent("config1");
        Component exec1 = buildExecComponent("exec1");

        ComponentInstance cfg1Instance = new ComponentInstance();
        cfg1Instance.setId(cfg1.getName() + "-1");
        cfg1Instance.setComponent(cfg1);
        cfg1Instance.getComponent().getArguments().getParameters().get(0).setValue("hello config1");

        ComponentInstance exec1Instance = new ComponentInstance();
        exec1Instance.setId(exec1.getName() + "-1");
        exec1Instance.setComponent(exec1);

        ComponentGraph componentGraph = new ComponentGraph();
        componentGraph.setName("demo1");
        Map<String, ComponentInstance> componentInstanceMap = new HashMap<>();
        componentGraph.setComponentInstanceMap(componentInstanceMap);
        componentInstanceMap.put(cfg1Instance.getId(), cfg1Instance);
        componentInstanceMap.put(exec1Instance.getId(), exec1Instance);

        Map<String, String> componentArgumentRelationship = new HashMap<>();
        componentGraph.setComponentArgumentRelationship(componentArgumentRelationship);
        String origPath = StringUtils.join(Arrays.asList(cfg1Instance.getComponent().getName(), cfg1Instance.getId(),
            cfg1Instance.getComponent().getArguments().getClass().getSimpleName(),
            "parameters",
            cfg1Instance.getComponent().getArguments().getParameters().get(0).getName()), '.');
        String dstPath = StringUtils.join(Arrays.asList(exec1Instance.getComponent().getName(), exec1Instance.getId(),
            exec1Instance.getComponent().getInputs().getClass().getSimpleName(),
            "parameters",
            exec1Instance.getComponent().getInputs().getParameters().get(0).getName()), '.');
        componentArgumentRelationship.put(origPath, dstPath);
        System.out.println(componentArgumentRelationship);

        String namespace = "argo";
        WorkflowCreateRequest body = buildWorkflow(namespace, componentGraph);
        JSON json = new JSON();
        System.out.println(json.serialize(body));

        Workflow response = api.createWorkflow(namespace, body);
        System.out.println(response);

    }

    private WorkflowCreateRequest buildWorkflow(String namespace, ComponentGraph componentGraph) {
        WorkflowCreateRequest body = new WorkflowCreateRequest();
        body.setServerDryRun(false); // if true, not create real wf
        body.setNamespace(namespace);
        body.setWorkflow(new Workflow());
        V1ObjectMeta metadata = new V1ObjectMeta();
        body.getWorkflow().setMetadata(metadata);
        metadata.setGenerateName(componentGraph.getName() + "-");
        metadata.setNamespace(namespace);
        Map<String, String> labels = new HashMap<>();
        metadata.setLabels(labels);
        labels.put("workflows.argoproj.io/completed", "false");
        WorkflowSpec spec = new WorkflowSpec();
        body.getWorkflow().setSpec(spec);
        List<Template> templates = new ArrayList<>();
        spec.setTemplates(templates);
        Arguments workflowArguments = new Arguments();
        spec.setArguments(workflowArguments);
        List<Parameter> workflowParams = new ArrayList<>();
        workflowArguments.setParameters(workflowParams);

        // 添加图
        String dagTmplName = componentGraph.getName() + "-dag";
        Template dagTmpl = new Template();
        templates.add(dagTmpl);
        DAGTemplate dag = new DAGTemplate();
        dagTmpl.setDag(dag);
        dagTmpl.setName(dagTmplName);
        List<DAGTask> tasks = new ArrayList<>();
        dag.setTasks(tasks);

        for (ComponentInstance compInst : componentGraph.getComponentInstanceMap().values()) {
            if (!StringUtils.equalsIgnoreCase(compInst.getComponent().getType(), "exec")) {
                // conf 节点
                workflowParams.addAll(compInst.getComponent().getArguments().getParameters());
                continue;
            }
            // 添加模板声明
            Template tmpl = new Template();
            templates.add(tmpl);
            tmpl.setName(compInst.getComponent().getName());
            tmpl.setInputs(compInst.getComponent().getInputs());
            tmpl.setOutputs(compInst.getComponent().getOutputs());
            tmpl.setContainer(compInst.getComponent().getContainer());

        }

        for (Entry<String, String> relation : componentGraph.getComponentArgumentRelationship().entrySet()) {
            String[] src = StringUtils.split(relation.getKey(), ".");
            String[] dst = StringUtils.split(relation.getValue(), ".");

            // 加入图
            ComponentInstance dstCompInst = componentGraph.getComponentInstanceMap().get(dst[1]);
            ComponentInstance srcCompInst = componentGraph.getComponentInstanceMap().get(src[1]);
            DAGTask dagTask = buildDAGTask(dstCompInst);
            Parameter dagTaskArg = new Parameter();
            dagTaskArg.setName(dstCompInst.getComponent().getInputs().getParameters().get(0).getName());
            dagTaskArg.setValue(
                String.format("{{workflow.parameters.%s}}",
                    srcCompInst.getComponent().getArguments().getParameters().get(0).getName()));
            Arguments taskArgs = new Arguments();
            dagTask.setArguments(taskArgs);
            taskArgs.setParameters(Arrays.asList(dagTaskArg));
            tasks.add(dagTask);
        }

        spec.setEntrypoint(dagTmpl.getName());

        return body;
    }

    private Component buildExecComponent(String name) {
        Component component = new Component();
        component.setName(name);
        component.setType("exec");

        Inputs inputs = new Inputs();
        component.setInputs(inputs);

        Parameter input1 = new Parameter();
        input1.setName(name + "-input1");
        inputs.setParameters(Arrays.asList(input1));

        Outputs outputs = new Outputs();
        component.setOutputs(outputs);
        Parameter output1 = new Parameter();
        output1.setName(name + "output1");
        ValueFrom outputValueFrom = new ValueFrom();
        outputValueFrom.setPath("/cowsay/README");
        output1.setValueFrom(outputValueFrom);
        output1.setDefault("this is default");
        outputs.setParameters(Arrays.asList(output1));

        V1Container container = new V1Container();
        component.setContainer(container);
        container.setImage("docker/whalesay:latest");
        container.setCommand(Arrays.asList("cowsay"));
        container.setArgs(Arrays.asList(
            "{{inputs.parameters." + component.getInputs().getParameters().get(0).getName() + "}}"));

        return component;
    }

    private Component buildConfComponent(String name) {
        Component component = new Component();
        component.setName(name);
        component.setType("conf");
        Arguments arguments = new Arguments();

        Parameter parameter = new Parameter();
        parameter.setName(name + "-attr1");
        arguments.setParameters(Arrays.asList(parameter));
        component.setArguments(arguments);
        return component;
    }

}
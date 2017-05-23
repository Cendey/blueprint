package com.mit.lab.norm;

import com.mit.lab.meta.Items;

import javax.script.*;

public class Script {

    private static Script instance;
    private ScriptEngineManager factory = new ScriptEngineManager();
    private ScriptEngine engine = factory.getEngineByName("javascript");
    private Bindings bindings = new SimpleBindings();
    private ScriptContext context = new SimpleScriptContext();

    public static Script getInstance() {
        if (instance == null) {
            instance = new Script();
        }
        return instance;
    }

    public void evaluate(Items params, String script) {
        if (params != null) {
            bindings.put("item", params);
            context.setBindings(bindings, ScriptContext.ENGINE_SCOPE);
            try {
                engine.eval(script, context);
            } catch (ScriptException e) {
                System.out.println(e.getCause().getMessage());
            }
        }
    }
}

import iosApp

class ContextHolder {
    let lifecycle: LifecycleRegistry
    let entry: AppEntry
    
    init() {
        lifecycle = LifecycleRegistryKt.LifecycleRegistry()
        entry = AppEntry(context: DefaultComponentContext(lifecycle: lifecycle))
        
        LifecycleRegistryExtKt.create(lifecycle)
    }

    deinit {
        LifecycleRegistryExtKt.destroy(lifecycle)
    }
}

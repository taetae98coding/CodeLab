import SwiftUI
import iosApp

@main
struct CodeLabApp: App {
    @UIApplicationDelegateAdaptor(AppDelegate.self)
    var appDelegate: AppDelegate
    
    init() {
        InitKoinKt.doInitKoin()
    }
    
	var body: some Scene {
		WindowGroup {
            ComposeView(entry: appDelegate.contextHolder.entry)
		}
	}
}

import SwiftUI

@main
struct CodeLabApp: App {
    @UIApplicationDelegateAdaptor(AppDelegate.self)
    var appDelegate: AppDelegate
    
	var body: some Scene {
		WindowGroup {
            ComposeView(entry: appDelegate.contextHolder.entry)
		}
	}
}

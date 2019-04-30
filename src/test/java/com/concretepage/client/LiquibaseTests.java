//package com.concretepage.client;
//
//
//import org.junit.Rule;
//import org.junit.Test;
//
//import org.springframework.boot.test.rule.OutputCapture;
//import org.springframework.core.NestedCheckedException;
//import static org.assertj.core.api.Assertions.assertThat;
//
//import java.net.ConnectException;
//
//import com.concretepage.MyApplication;
//
//public class LiquibaseTests {
//
//	@Rule
//	public final OutputCapture output = new OutputCapture();
//
//	@Test
//	public void testDefaultSettings() throws Exception {
//
//		System.out.println(" LiquibaseTests  LiquibaseTests  LiquibaseTests  LiquibaseTests ::> "
//		+this.output.toString()+":HELLO");
//		try {
//			MyApplication.main(new String[] { "--server.port=0" });
//		}
//		catch (IllegalStateException ex) {
//			if (serverNotRunning(ex)) {
//				return;
//			}
//		}
//
//		System.out.println("OUTPUT ::>>>>>>>>>>>> "+this.output);
//		System.out.println("OUTPUT ::>>>>>>>>>>>> "+this.output.toString());
//		assertThat(this.output.toString()).contains("Successfully acquired change log lock");
//		assertThat(this.output.toString()).contains("New row inserted into person");
//
////		assertThat(this.output.toString())
////				.contains("Successfully acquired change log lock")
////				.contains("Creating database history "
////						+ "table with name: PUBLIC.DATABASECHANGELOG")
////				.contains("Table person created")
////				.contains("ChangeSet classpath:/db/"
////						+ "changelog/db.changelog-master.yaml::1::"
////						+ "marceloverdijk ran successfully")
////				.contains("New row inserted into person")
////				.contains("ChangeSet classpath:/db/changelog/"
////						+ "db.changelog-master.yaml::2::"
////						+ "marceloverdijk ran successfully")
////				.contains("Successfully released change log lock");
//	}
//
//	@SuppressWarnings("serial")
//	private boolean serverNotRunning(IllegalStateException ex) {
//		NestedCheckedException nested = new NestedCheckedException("failed", ex) {
//		};
//		if (nested.contains(ConnectException.class)) {
//			Throwable root = nested.getRootCause();
//			if (root.getMessage().contains("Connection refused")) {
//				return true;
//			}
//		}
//		return false;
//	}
//}

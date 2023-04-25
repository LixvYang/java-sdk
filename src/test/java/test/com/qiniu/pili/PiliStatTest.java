package test.com.qiniu.pili;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.qiniu.pili.PiliStatManager;
import com.qiniu.pili.PiliStatModel;
import com.qiniu.util.Auth;

import test.com.qiniu.ResCode;
import test.com.qiniu.TestConfig;

public class PiliStatTest {
  private PiliStatManager statManager;

  /**
   * 初始化
   *
   * @throws Exception
   */
  @BeforeEach
  public void setUp() throws Exception {
    statManager = new PiliStatManager(
        Auth.create(TestConfig.piliAccessKey, TestConfig.piliSecretKey), TestConfig.piliHTTPhost);
  }

  @Test
  @Tag("UnitTest")
  public void testGetStatUpflow() {
    PiliStatModel statModel = new PiliStatModel();
    PiliStatModel.GetStatCommonRequest commentReq = statModel.new GetStatCommonRequest();
    commentReq.begin = "20060102150405";
    commentReq.end = "20060102";
    commentReq.g = "hour";

    Map<String, String[]> where = new HashMap<>();
    where.put("hub", new String[] { TestConfig.piliTestHub });
    String[] select = { "flow" };
    PiliStatModel.GetStatUpflowRequest param = statModel.new GetStatUpflowRequest();
    param.commonRequest =  statModel.new GetStatCommonRequest();
    param.commonRequest.begin = commentReq.begin;
    param.commonRequest.end = commentReq.end;
    param.commonRequest.g = commentReq.g;
    param.where = where;
    param.select = select;
    try {
      PiliStatModel.StatResponse[] response = statManager.getStatUpflow(param);
      System.out.println("statManager.getStatUpflow: success: " + response);
      assertNotNull(response);
    } catch (Exception e) {
      System.out.println("statManager.getStatUpflow: response: ");
      System.out.println(e);
      assertTrue(ResCode.find(e.hashCode(), ResCode.getPossibleResCode(401)));
    }
  }
}

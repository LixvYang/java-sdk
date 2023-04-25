package test.com.qiniu.pili;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.qiniu.common.QiniuException;
import com.qiniu.pili.PiliDomainManager;
import com.qiniu.pili.PiliDomainModel;
import com.qiniu.util.Auth;

import test.com.qiniu.ResCode;
import test.com.qiniu.TestConfig;

public class PiliDomainTest {
  private PiliDomainManager domainManager;

  /**
   * 初始化
   *
   * @throws Exception
   */
  @BeforeEach
  public void setUp() throws Exception {
    this.domainManager = new PiliDomainManager(
        Auth.create(TestConfig.piliAccessKey, TestConfig.piliSecretKey), TestConfig.piliHTTPhost);
  }

  @Test
  @Tag("UnitTest")
  public void testGetDomainsList() {
    try {
      PiliDomainModel.DomainsListResult response = domainManager.getDomainsList("testml1");
      System.out.println("response: " + response);
      assertNotNull(response);
    } catch (QiniuException e) {
      System.out.println("Err response: " + e);
      assertTrue(ResCode.find(e.code(), ResCode.getPossibleResCode(401)));
    }
  }

  @Test
  @Tag("UnitTest")
  public void testGetDomainInfo() {
    try {
      PiliDomainModel.DomainInfoResult response = domainManager.getDomainInfo("testml1",
          "pili-publish.testml1.cloudvdn.com");
      assertNotNull(response);
    } catch (QiniuException e) {
      assertTrue(ResCode.find(e.code(), ResCode.getPossibleResCode(401)));
    }
  }

  @Test
  @Tag("UnitTest")
  public void testBindDomain() {
    String hub = "testml1";
    String domain = "mcs-admin.qiniuapi.com";
    String type = "liveHls"; // or "live_hls", "live_hdl", "playback_hls"

    try {
      QiniuException exception = domainManager.bindDomain(hub, domain, type);
      if (exception != null) {
        System.out.println("Failed to bind domain: " + exception.getMessage());
      } else {
        System.out.println("Domain binding succeeded.");
      }
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  @Test
  @Tag("UnitTest")
  public void testUnBindDomain() {
    String hub = "testml1";
    String domain = "mcs-admin.qiniuapi.com";

    try {
      QiniuException exception = domainManager.unbindDomain(hub, domain);
      if (exception != null) {
        System.out.println("Failed to bind domain: " + exception.getMessage());
      } else {
        System.out.println("Domain binding succeeded.");
      }
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  @Test
  @Tag("UnitTest")
  public void testBindVodDomain() {
    String hub = "testml1";
    String vodDomain = "mcs-admin.qiniuapi.com";

    try {
      QiniuException exception = domainManager.bindVodDomain(hub, vodDomain);
      if (exception != null) {
        System.out.println("Failed to unbind domain: " + exception.getMessage());
      } else {
        System.out.println("Domain unbind succeeded.");
      }
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  @Test
  @Tag("UnitTest")
  public void testSetDomainCert() {
    String hub = "testml1";
    String domain = "mcs-admin.qiniuapi.com";
    String certName = "63f474b5f18f8d24fd0b3670";

    try {
      QiniuException exception = domainManager.setDomainCert(hub, domain, certName);
      if (exception != null) {
        System.out.println("Failed to setDomainCert domain: " + exception.getMessage());
      } else {
        System.out.println("Domain setDomainCert succeeded.");
      }
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  @Test
  @Tag("UnitTest")
  public void testSetDomainURLRewrite() {
    String hub = "testml1";
    String domain = "mcs-admin.qiniuapi.com";
    List<PiliDomainModel.Rules> rules = new ArrayList<>();

    rules.add(new PiliDomainModel.Rules("(.+)/live/(.+)/playlist.m3u8", "${1}/hub/${2}.m3u8"));
    rules.add(new PiliDomainModel.Rules("pattern2", "replacement2"));

    try {
      QiniuException exception = domainManager.setDomainURLRewrite(hub, domain, rules);
      if (exception != null) {
        System.out.println("Failed to setDomainCert domain: " + exception.getMessage());
      } else {
        System.out.println("Domain setDomainCert succeeded.");
      }
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}

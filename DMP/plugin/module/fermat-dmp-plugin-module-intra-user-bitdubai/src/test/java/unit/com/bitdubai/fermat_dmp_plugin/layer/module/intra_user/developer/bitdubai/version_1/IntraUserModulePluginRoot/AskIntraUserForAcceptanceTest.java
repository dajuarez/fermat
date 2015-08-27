package unit.com.bitdubai.fermat_dmp_plugin.layer.module.intra_user.developer.bitdubai.version_1.IntraUserModulePluginRoot;

import com.bitdubai.fermat_api.layer.all_definition.IntraUsers.IntraUserSettings;
import com.bitdubai.fermat_api.layer.all_definition.util.XMLParser;
import com.bitdubai.fermat_api.layer.dmp_actor.intra_user.interfaces.ActorIntraUserManager;
import com.bitdubai.fermat_api.layer.dmp_identity.intra_user.interfaces.IntraUserIdentity;
import com.bitdubai.fermat_api.layer.dmp_module.intra_user.exceptions.CantAcceptRequestException;
import com.bitdubai.fermat_api.layer.dmp_network_service.intra_user.interfaces.IntraUserManager;
import com.bitdubai.fermat_api.layer.osa_android.database_system.DatabaseFactory;
import com.bitdubai.fermat_api.layer.osa_android.file_system.FileLifeSpan;
import com.bitdubai.fermat_api.layer.osa_android.file_system.FilePrivacy;
import com.bitdubai.fermat_api.layer.osa_android.file_system.PluginFileSystem;
import com.bitdubai.fermat_api.layer.osa_android.file_system.PluginTextFile;
import com.bitdubai.fermat_dmp_plugin.layer.module.intra_user.developer.bitdubai.version_1.IntraUserModulePluginRoot;
import com.bitdubai.fermat_dmp_plugin.layer.module.intra_user.developer.bitdubai.version_1.structure.IntraUsersModuleLoginConstants;
import com.bitdubai.fermat_pip_api.layer.pip_platform_service.error_manager.ErrorManager;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.UUID;

import static com.googlecode.catchexception.CatchException.catchException;
import static com.googlecode.catchexception.CatchException.caughtException;
import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

/**
 * Created by natalia on 20/08/15.
 */

@RunWith(MockitoJUnitRunner.class)
public class AskIntraUserForAcceptanceTest extends TestCase {
    /**
     * DealsWithErrors interface Mocked
     */
    @Mock
    private ErrorManager mockErrorManager;

    /**
     * UsesFileSystem Interface member variables.
     */
    @Mock
    private PluginFileSystem mockPluginFileSystem;


    /**
     * DealWithActorIntraUserManager Interface member variables.
     */
    @Mock
    private ActorIntraUserManager mockActorIntraUserManager;


    /**
     * DealWithIntraUserNetworkServiceManager Interface member variables.
     */
    @Mock
    private IntraUserManager mockIntraUserNetworkServiceManager;

    @Mock
    private PluginTextFile mockIntraUserLoginXml;

    @Mock
    IntraUserIdentity mockIntraUserIdentity;

    @Mock
    IntraUserSettings intraUserSettings = new IntraUserSettings();

    private IntraUserModulePluginRoot testIntraUserModulePluginRoot;


    private UUID pluginId;
    private String intraUserAlias = "intraUserTest";

    private String intraUserPublicKey ;

    private byte[] intraUserImageProfile = new byte[0];

    @Before
    public void setUp() throws Exception{


        pluginId= UUID.randomUUID();
        intraUserPublicKey = UUID.randomUUID().toString();

        MockitoAnnotations.initMocks(this);

        pluginId= UUID.randomUUID();
        testIntraUserModulePluginRoot = new IntraUserModulePluginRoot();
        testIntraUserModulePluginRoot.setPluginFileSystem(mockPluginFileSystem);
        testIntraUserModulePluginRoot.setErrorManager(mockErrorManager);

        testIntraUserModulePluginRoot.setActorIntraUserManager(mockActorIntraUserManager);
        testIntraUserModulePluginRoot.setIntraUserNetworkServiceManager(mockIntraUserNetworkServiceManager);

        setUpMockitoRules();
        testIntraUserModulePluginRoot.setId(pluginId);

        testIntraUserModulePluginRoot.start();

    }

    public void setUpMockitoRules()  throws Exception{

        when(mockPluginFileSystem.getTextFile(pluginId, pluginId.toString(), "intraUsersLogin", FilePrivacy.PRIVATE, FileLifeSpan.PERMANENT)).thenReturn(mockIntraUserLoginXml);
        when(mockIntraUserLoginXml.getContent()).thenReturn(XMLParser.parseObject(intraUserSettings));


    }

    @Ignore
    @Test
    public void askIntraUserForAcceptanceTest_AskedOk_throwsCantAcceptRequestException() throws Exception{


        catchException(testIntraUserModulePluginRoot).askIntraUserForAcceptance(intraUserAlias, intraUserPublicKey, intraUserImageProfile);

        assertThat(caughtException()).isNull();

    }

    @Ignore
    @Test
    public void askIntraUserForAcceptanceTest_AskedError_throwsCantAcceptRequestException() throws Exception{

        testIntraUserModulePluginRoot.setIntraUserNetworkServiceManager(null);

        catchException(testIntraUserModulePluginRoot).askIntraUserForAcceptance(intraUserAlias, intraUserPublicKey, intraUserImageProfile);

        assertThat(caughtException())
                .isNotNull()
                .isInstanceOf(CantAcceptRequestException.class);


    }
}

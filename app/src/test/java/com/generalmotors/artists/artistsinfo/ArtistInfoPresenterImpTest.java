
                                                                                                                                                                                                        
package com.generalmotors.artists.artistsinfo;

import static org.mockito.MockitoAnnotations.initMocks;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
    import static org.mockito.ArgumentMatchers.any;
    import static org.mockito.ArgumentMatchers.anyInt;
    import static org.mockito.ArgumentMatchers.anyString;
    import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.InjectMocks;
import org.mockito.stubbing.Answer;

public class ArtistInfoPresenterImpTest {

    private com.generalmotors.artists.artistsinfo.ArtistInfoPresenterImp artistInfoPresenterImpUnderTest;

@Before
public void setUp() throws Exception {
                                artistInfoPresenterImpUnderTest = new ArtistInfoPresenterImp(null) ;
}
                
    @Test     public void testGetArtistsInfo() throws Exception {
    // Setup
        
    // Run the test
 artistInfoPresenterImpUnderTest.getArtistsInfo("artistsName");

        // Verify the results
    }
                                                                    }


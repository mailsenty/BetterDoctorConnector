
package org.mule.modules.betterdoctor.generated.adapters;

import javax.annotation.Generated;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.api.devkit.ProcessAdapter;
import org.mule.api.devkit.ProcessTemplate;
import org.mule.api.processor.MessageProcessor;
import org.mule.api.routing.filter.Filter;
import org.mule.modules.betterdoctor.BetterDoctorConnector;
import org.mule.security.oauth.callback.ProcessCallback;


/**
 * A <code>BetterDoctorConnectorProcessAdapter</code> is a wrapper around {@link BetterDoctorConnector } that enables custom processing strategies.
 * 
 */
@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.9.0", date = "2017-09-03T01:24:41-04:00", comments = "Build UNNAMED.2793.f49b6c7")
public class BetterDoctorConnectorProcessAdapter
    extends BetterDoctorConnectorLifecycleInjectionAdapter
    implements ProcessAdapter<BetterDoctorConnectorCapabilitiesAdapter>
{


    public<P >ProcessTemplate<P, BetterDoctorConnectorCapabilitiesAdapter> getProcessTemplate() {
        final BetterDoctorConnectorCapabilitiesAdapter object = this;
        return new ProcessTemplate<P,BetterDoctorConnectorCapabilitiesAdapter>() {


            @Override
            public P execute(ProcessCallback<P, BetterDoctorConnectorCapabilitiesAdapter> processCallback, MessageProcessor messageProcessor, MuleEvent event)
                throws Exception
            {
                return processCallback.process(object);
            }

            @Override
            public P execute(ProcessCallback<P, BetterDoctorConnectorCapabilitiesAdapter> processCallback, Filter filter, MuleMessage message)
                throws Exception
            {
                return processCallback.process(object);
            }

        }
        ;
    }

}

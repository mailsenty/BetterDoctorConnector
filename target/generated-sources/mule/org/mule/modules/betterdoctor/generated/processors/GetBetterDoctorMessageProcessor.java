
package org.mule.modules.betterdoctor.generated.processors;

import java.util.List;
import javax.annotation.Generated;
import org.mule.api.MuleEvent;
import org.mule.api.MuleException;
import org.mule.api.config.ConfigurationException;
import org.mule.api.devkit.ProcessAdapter;
import org.mule.api.devkit.ProcessTemplate;
import org.mule.api.lifecycle.InitialisationException;
import org.mule.api.processor.MessageProcessor;
import org.mule.api.registry.RegistrationException;
import org.mule.common.DefaultResult;
import org.mule.common.FailureType;
import org.mule.common.Result;
import org.mule.common.metadata.ConnectorMetaDataEnabled;
import org.mule.common.metadata.DefaultMetaData;
import org.mule.common.metadata.DefaultMetaDataKey;
import org.mule.common.metadata.DefaultPojoMetaDataModel;
import org.mule.common.metadata.DefaultSimpleMetaDataModel;
import org.mule.common.metadata.MetaData;
import org.mule.common.metadata.MetaDataKey;
import org.mule.common.metadata.MetaDataModel;
import org.mule.common.metadata.OperationMetaDataEnabled;
import org.mule.common.metadata.datatype.DataType;
import org.mule.common.metadata.datatype.DataTypeFactory;
import org.mule.devkit.internal.metadata.fixes.STUDIO7157;
import org.mule.devkit.processor.DevkitBasedMessageProcessor;
import org.mule.modules.betterdoctor.BetterDoctorConnector;
import org.mule.security.oauth.callback.ProcessCallback;


/**
 * GetBetterDoctorMessageProcessor invokes the {@link org.mule.modules.betterdoctor.BetterDoctorConnector#getBetterDoctor(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)} method in {@link BetterDoctorConnector }. For each argument there is a field in this processor to match it.  Before invoking the actual method the processor will evaluate and transform where possible to the expected argument type.
 * 
 */
@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.9.0", date = "2017-09-03T01:24:41-04:00", comments = "Build UNNAMED.2793.f49b6c7")
public class GetBetterDoctorMessageProcessor
    extends DevkitBasedMessageProcessor
    implements MessageProcessor, OperationMetaDataEnabled
{

    protected Object first_name;
    protected String _first_nameType;
    protected Object last_name;
    protected String _last_nameType;
    protected Object gender;
    protected String _genderType;
    protected Object location;
    protected String _locationType;
    protected Object specialtyuid;
    protected String _specialtyuidType;

    public GetBetterDoctorMessageProcessor(String operationName) {
        super(operationName);
    }

    /**
     * Obtains the expression manager from the Mule context and initialises the connector. If a target object  has not been set already it will search the Mule registry for a default one.
     * 
     * @throws InitialisationException
     */
    public void initialise()
        throws InitialisationException
    {
    }

    @Override
    public void start()
        throws MuleException
    {
        super.start();
    }

    @Override
    public void stop()
        throws MuleException
    {
        super.stop();
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    /**
     * Sets gender
     * 
     * @param value Value to set
     */
    public void setGender(Object value) {
        this.gender = value;
    }

    /**
     * Sets specialtyuid
     * 
     * @param value Value to set
     */
    public void setSpecialtyuid(Object value) {
        this.specialtyuid = value;
    }

    /**
     * Sets last_name
     * 
     * @param value Value to set
     */
    public void setLast_name(Object value) {
        this.last_name = value;
    }

    /**
     * Sets location
     * 
     * @param value Value to set
     */
    public void setLocation(Object value) {
        this.location = value;
    }

    /**
     * Sets first_name
     * 
     * @param value Value to set
     */
    public void setFirst_name(Object value) {
        this.first_name = value;
    }

    /**
     * Invokes the MessageProcessor.
     * 
     * @param event MuleEvent to be processed
     * @throws Exception
     */
    public MuleEvent doProcess(final MuleEvent event)
        throws Exception
    {
        Object moduleObject = null;
        try {
            moduleObject = findOrCreate(null, false, event);
            final String _transformedFirst_name = ((String) evaluateAndTransform(getMuleContext(), event, GetBetterDoctorMessageProcessor.class.getDeclaredField("_first_nameType").getGenericType(), null, first_name));
            final String _transformedLast_name = ((String) evaluateAndTransform(getMuleContext(), event, GetBetterDoctorMessageProcessor.class.getDeclaredField("_last_nameType").getGenericType(), null, last_name));
            final String _transformedGender = ((String) evaluateAndTransform(getMuleContext(), event, GetBetterDoctorMessageProcessor.class.getDeclaredField("_genderType").getGenericType(), null, gender));
            final String _transformedLocation = ((String) evaluateAndTransform(getMuleContext(), event, GetBetterDoctorMessageProcessor.class.getDeclaredField("_locationType").getGenericType(), null, location));
            final String _transformedSpecialtyuid = ((String) evaluateAndTransform(getMuleContext(), event, GetBetterDoctorMessageProcessor.class.getDeclaredField("_specialtyuidType").getGenericType(), null, specialtyuid));
            Object resultPayload;
            final ProcessTemplate<Object, Object> processTemplate = ((ProcessAdapter<Object> ) moduleObject).getProcessTemplate();
            resultPayload = processTemplate.execute(new ProcessCallback<Object,Object>() {


                public List<Class<? extends Exception>> getManagedExceptions() {
                    return null;
                }

                public boolean isProtected() {
                    return false;
                }

                public Object process(Object object)
                    throws Exception
                {
                    return ((BetterDoctorConnector) object).getBetterDoctor(_transformedFirst_name, _transformedLast_name, _transformedGender, _transformedLocation, _transformedSpecialtyuid);
                }

            }
            , this, event);
            event.getMessage().setPayload(resultPayload);
            return event;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Result<MetaData> getInputMetaData() {
        return new DefaultResult<MetaData>(null, (Result.Status.SUCCESS));
    }

    @Override
    public Result<MetaData> getOutputMetaData(MetaData inputMetadata) {
        MetaDataModel metaDataPayload = getPojoOrSimpleModel(String.class);
        DefaultMetaDataKey keyForStudio = new DefaultMetaDataKey("OUTPUT_METADATA", null);
        metaDataPayload.addProperty(STUDIO7157 .getStructureIdentifierMetaDataModelProperty(keyForStudio, false, false));
        return new DefaultResult<MetaData>(new DefaultMetaData(metaDataPayload));
    }

    private MetaDataModel getPojoOrSimpleModel(Class clazz) {
        DataType dataType = DataTypeFactory.getInstance().getDataType(clazz);
        if (DataType.POJO.equals(dataType)) {
            return new DefaultPojoMetaDataModel(clazz);
        } else {
            return new DefaultSimpleMetaDataModel(dataType);
        }
    }

    public Result<MetaData> getGenericMetaData(MetaDataKey metaDataKey) {
        ConnectorMetaDataEnabled connector;
        try {
            connector = ((ConnectorMetaDataEnabled) findOrCreate(null, false, null));
            try {
                Result<MetaData> metadata = connector.getMetaData(metaDataKey);
                if ((Result.Status.FAILURE).equals(metadata.getStatus())) {
                    return metadata;
                }
                if (metadata.get() == null) {
                    return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), "There was an error processing metadata at BetterDoctorConnector at getBetterDoctor retrieving was successful but result is null");
                }
                return metadata;
            } catch (Exception e) {
                return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), e.getMessage(), FailureType.UNSPECIFIED, e);
            }
        } catch (ClassCastException cast) {
            return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), "There was an error getting metadata, there was no connection manager available. Maybe you're trying to use metadata from an Oauth connector");
        } catch (ConfigurationException e) {
            return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), e.getMessage(), FailureType.UNSPECIFIED, e);
        } catch (RegistrationException e) {
            return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), e.getMessage(), FailureType.UNSPECIFIED, e);
        } catch (IllegalAccessException e) {
            return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), e.getMessage(), FailureType.UNSPECIFIED, e);
        } catch (InstantiationException e) {
            return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), e.getMessage(), FailureType.UNSPECIFIED, e);
        } catch (Exception e) {
            return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), e.getMessage(), FailureType.UNSPECIFIED, e);
        }
    }

}

package io.tracee.contextlogger.builder;

import io.tracee.contextlogger.api.TraceeContextLogBuilder;
import io.tracee.contextlogger.profile.Profile;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Abstract base class for all context toJson builder implementations.
 * Created by Tobias Gindler, holisticon AG on 20.03.14.
 */
public abstract class AbstractContextLogBuilder implements TraceeContextLogBuilder {

	private Set<Class> wrapperClasses;
	private Profile profile;
	private Map<String, Boolean> manualContextOverrides;

	@Override
	public final Set<Class> getWrapperClasses() {
		return wrapperClasses;
	}

	@Override
	public final void setWrapperClasses(Set<Class> wrapperClasses) {
		this.wrapperClasses = wrapperClasses;
	}

	public final void setProfile(final Profile profile) {
		this.profile = profile;
	}

	public final Profile getProfile() {
		return this.profile;
	}

	public final void setManualContextOverrides(final Map<String, Boolean> manualContextOverrides) {
		this.manualContextOverrides = manualContextOverrides;
	}

	public final Map<String, Boolean> getManualContextOverrides() {
		return manualContextOverrides != null ? manualContextOverrides : new HashMap<String, Boolean>();
	}

}

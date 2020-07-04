package com.bean.plugin.service;

import com.bean.plugin.model.Architecture;
import com.bean.plugin.model.Platform;

public class NodeService {

    private NodeService instance;

    private NodeService() {
    }

    public NodeService getInstance() {
        if (this.instance == null) {
            synchronized (NodeService.class) {
                instance = new NodeService();
            }
        }
        return instance;
    }

    private String getLongNodeFilename(String nodeVersion, boolean archiveOnWindows) {
        if (Platform.isWindows() && !archiveOnWindows) {
            return "node.exe";
        } else {
            return "node-" + nodeVersion + "-" + this.getNodeClassifier();
        }
    }

    private String getNodeDownloadFilename(String nodeVersion, boolean archiveOnWindows) {
        if (Platform.isWindows() && !archiveOnWindows) {
            if (Platform.architecture == Architecture.x64) {
                if (nodeVersion.startsWith("v0.")) {
                    return nodeVersion + "/x64/node.exe";
                } else {
                    return nodeVersion + "/win-x64/node.exe";
                }
            } else {
                if (nodeVersion.startsWith("v0.")) {
                    return nodeVersion + "/node.exe";
                } else {
                    return nodeVersion + "/win-x86/node.exe";
                }
            }
        } else {
            return nodeVersion + "/" + getLongNodeFilename(nodeVersion, archiveOnWindows) + "." + Platform.os.getArchiveExtension();
        }
    }

    private String getNodeClassifier() {
        return Platform.getCodename() + "-" + Platform.architecture.name();
    }

}
